package com.example.dm2.actividades17_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Actividad3_1 extends AppCompatActivity implements Button.OnClickListener{
    private Button volver;
    private TextView textoresultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3_1);

        volver=(Button)findViewById(R.id.volver);
        volver.setOnClickListener(this);
        textoresultado=(TextView)findViewById(R.id.textoresultado);


        if(comprobar())
        {
           textoresultado.setText("El resultado de la suma ha sido correcto");
        }
        else
        {
            textoresultado.setText("El resultado de la suma ha sido incorrecto");
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad3_1, menu);
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
    public boolean comprobar()
    {

        Bundle extras=getIntent().getExtras();
        int num1=Integer.parseInt(extras.getString("numero1").toString());
        int num2=Integer.parseInt(extras.getString("numero2").toString());
        int resultado=Integer.parseInt(extras.getString("resultado").toString());

        if((num1+num2)==resultado)
            return true;

        return false;
    }

    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent();
        if(comprobar())
        {
            intent.putExtra("respuesta", "acertado");
        }
        else
        {
            intent.putExtra("respuesta", "fallado");
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}
