package com.example.dm2.actividades17_intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;

public class Actividad4_1 extends AppCompatActivity {
    private TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad4_1);
        texto=(TextView)findViewById(R.id.texto);

        Bundle extras=getIntent().getExtras();
        String usu=extras.getString("nombre").toString();
        String ape=extras.getString("apellido").toString();
        String sexo=extras.getString("sexo").toString();
        String[] afi=extras.getStringArray("aficiones");



        String imprime="";
        imprime+="Nombre: "+usu+" Apellido: "+ape;
        imprime+="\nSexo: "+sexo;
        imprime+="\nAficiones: ";

        for(int i=0;i<afi.length;i++)
        {
            imprime+="\n"+afi[i];
        }
        texto.setText(imprime);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad4_1, menu);
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
}
