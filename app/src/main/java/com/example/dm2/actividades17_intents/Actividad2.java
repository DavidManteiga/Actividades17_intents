package com.example.dm2.actividades17_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Actividad2 extends AppCompatActivity implements Button.OnClickListener {

    private EditText usuario;
    private EditText pass;
    private Button btaceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        usuario=(EditText)findViewById(R.id.usuario);
        pass=(EditText)findViewById(R.id.pass);
        btaceptar=(Button)findViewById(R.id.btaceptar);
       btaceptar.setOnClickListener(this);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad2, menu);
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
        if(!(usuario.getText().toString().equals(""))&& !(pass.getText().toString().equals("")))
        {
            Intent intent = new Intent(this, Actividad2_1.class);
            intent.putExtra("usuario", usuario.getText().toString());
            intent.putExtra("pass", pass.getText().toString());
            startActivity(intent);
        }

    }
}
