package com.example.dm2.actividades17_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Actividad2_1 extends AppCompatActivity implements Button.OnClickListener{

    private Button btvolver;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2_1);

        btvolver=(Button)findViewById(R.id.btvolver);
        texto=(TextView)findViewById(R.id.txttexto);

        btvolver.setOnClickListener(this);


        Bundle extras=getIntent().getExtras();
        String usu=extras.getString("usuario").toString();
        String pass=extras.getString("pass").toString();

        if((usu.equals("david"))&&(pass.equals("1111")))
        {
            texto.setText("Usuario y contraseña correctos");
        }
        else
        {
            texto.setText("Usuario y contraseña incorrectos");
        }




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad2_1, menu);
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
    public void onClick(View v) {
        Intent intent = new Intent(this, Actividad2.class);

        startActivity(intent);


    }
}
