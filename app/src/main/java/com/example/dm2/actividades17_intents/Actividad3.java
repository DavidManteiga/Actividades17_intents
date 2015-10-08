package com.example.dm2.actividades17_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Actividad3 extends AppCompatActivity implements Button.OnClickListener{

    private TextView numero1;
    private TextView numero2;
    private TextView totalacertadas;
    private Button comprobar;
    private EditText resultado;
    private int correctas=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3);

        numero1= (TextView) findViewById(R.id.numero1);
        numero2= (TextView) findViewById(R.id.numero2);
        totalacertadas= (TextView) findViewById(R.id.totalacertadas);
        numero1.setText((int) (Math.random()*10)+"");
        numero2.setText((int) (Math.random()*10)+"");

        resultado= (EditText)findViewById(R.id.resultado);
        comprobar=(Button)findViewById(R.id.comprobar);
        comprobar.setOnClickListener(this);

        totalacertadas.setText("Total acertadas= "+correctas);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent(this, Actividad3_1.class);
        intent.putExtra("numero1", numero1.getText().toString());
        intent.putExtra("numero2", numero2.getText().toString());
        intent.putExtra("resultado", resultado.getText().toString());
        startActivityForResult(intent, 2222);

    }
    @Override
    protected void onActivityResult (int requestCode,int resultCode, Intent data) {
        if (requestCode==2222 && resultCode==RESULT_OK)
        {
            String res = data.getExtras().getString("respuesta");

            if(res.equals("acertado"))
            {
                correctas++;
            }

            totalacertadas.setText("Total acertadas= "+correctas);
            numero1.setText((int) (Math.random()*10)+"");
            numero2.setText((int) (Math.random()*10)+"");
            resultado.setText("");

        }
    }
}
