package com.example.dm2.actividades17_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Actividad1_1 extends AppCompatActivity implements Button.OnClickListener{

    private Button aceptar;
    private Button rechazar;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1_1);

        aceptar=(Button)findViewById(R.id.aceptar);
        rechazar=(Button)findViewById(R.id.rechazar);
        texto=(TextView)findViewById(R.id.txttexto);

        aceptar.setOnClickListener(this);

        Bundle extras=getIntent().getExtras();
        String nom=extras.getString("nombre").toString();
        String ape=extras.getString("apellido").toString();

        texto.setText(nom+" "+ape);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad1_1, menu);
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
        Intent intent = new Intent();
        if(v.getId()==findViewById(R.id.aceptar).getId())
        {

            intent.putExtra("pulsado", "aceptar");

        }
        if(v.getId()==findViewById(R.id.rechazar).getId())
        {
            intent.putExtra("pulsado", "rechazar");
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}
