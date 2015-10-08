package com.example.dm2.actividades17_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Actividad4 extends AppCompatActivity implements Button.OnClickListener{

    private TextView txttexto;
    private EditText nombre;
    private EditText apellido;
    private Button btenviar;
    private RadioButton hombre;
    private RadioButton mujer;
    private CheckBox viajar;
    private CheckBox musica;
    private CheckBox lectura;
    private CheckBox deportes;
    private RadioGroup grupo;
    private String sexo;
    private String[] selec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad4);

        txttexto= (TextView) findViewById(R.id.txttexto);
        nombre= (EditText) findViewById(R.id.nombre);
        apellido= (EditText) findViewById(R.id.apellido);
        hombre=(RadioButton)findViewById(R.id.hombre);
        mujer=(RadioButton)findViewById(R.id.mujer);
        viajar=(CheckBox)findViewById(R.id.viajar);
        musica=(CheckBox)findViewById(R.id.musica);
        lectura=(CheckBox)findViewById(R.id.lectura);
        deportes=(CheckBox)findViewById(R.id.deportes);
        grupo=(RadioGroup)findViewById(R.id.grupo);
        btenviar=(Button)findViewById(R.id.btenviar);
        btenviar.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad4, menu);
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
        if(comprobar())
        {
            Intent intent = new Intent(this, Actividad4_1.class);
            intent.putExtra("nombre", nombre.getText().toString());
            intent.putExtra("apellido", apellido.getText().toString());
            intent.putExtra("aficiones", selec);
            intent.putExtra("sexo", sexo);
            startActivity(intent);
        }
        else
        {
            txttexto.setText("Rellene todos los campos");
        }
    }

    public boolean comprobar()
    {


        if(nombre.getText().toString().equals(""))
        {
             return false;
        }
        if(apellido.getText().toString().equals(""))
        {
            return false;
        }
        if((!hombre.isChecked())&&(!mujer.isChecked()))
        {
            return false;
        }
        if(hombre.isChecked())
        {
            sexo="hombre";
        }
        else
        {
            sexo="mujer";
        }

        boolean valida=false;
        CheckBox seleccionados[]={viajar,deportes,lectura,musica};
        int num=0;

        for(int i=0;i<seleccionados.length;i++)
        {
            CheckBox actual=seleccionados[i];
            if(actual.isChecked())
            {
                valida =true;
                num++;

            }

        }
        selec= new String[num];
        int x=0;

        for(int i=0;i<seleccionados.length;i++)
        {
            CheckBox actual=seleccionados[i];
            if(actual.isChecked())
            {
                selec[x]=actual.getText().toString();
                x++;

            }

        }


        return valida;



    }


}
