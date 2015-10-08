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

public class Actividad1 extends AppCompatActivity implements Button.OnClickListener{

    private EditText nombre;
    private EditText apellido;
    private Button validarcondiciones;
    private TextView condiciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        nombre=(EditText)findViewById(R.id.nombre);
        apellido=(EditText)findViewById(R.id.apellido);
        validarcondiciones=(Button)findViewById(R.id.validarcondiciones);
        condiciones=(TextView)findViewById(R.id.condiciones);

        validarcondiciones.setOnClickListener(this);;



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad1, menu);
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
        Intent intent = new Intent(this, Actividad1_1.class);
        intent.putExtra("nombre", nombre.getText().toString());
        intent.putExtra("apellido", apellido.getText().toString());
        startActivityForResult(intent, 1111);
    }

    @Override
    protected void onActivityResult (int requestCode,int resultCode, Intent data) {
        if (requestCode==1111 && resultCode==RESULT_OK)
        {
            String res = data.getExtras().getString("pulsado");

            if(res.equals("aceptar"))
            {
                condiciones.setText("Condiciones aceptadas");
            }
            if(res.equals("rechazar"))
            {
                condiciones.setText("Condiciones rechazadas");
            }
        }
    }
}
