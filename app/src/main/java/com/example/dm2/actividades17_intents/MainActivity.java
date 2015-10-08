package com.example.dm2.actividades17_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    private Button actividad1;
    private Button actividad2;
    private Button actividad3;
    private Button actividad4;
    private Button actividad5;
    private Button salir;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actividad1=(Button)findViewById(R.id.actividad1);
        actividad2=(Button)findViewById(R.id.actividad2);
        actividad3=(Button)findViewById(R.id.actividad3);
        actividad4=(Button)findViewById(R.id.actividad4);
        actividad5=(Button)findViewById(R.id.actividad5);
        salir=(Button)findViewById(R.id.salir);

        actividad1.setOnClickListener(this);
        actividad2.setOnClickListener(this);
        actividad3.setOnClickListener(this);
        actividad4.setOnClickListener(this);
        actividad5.setOnClickListener(this);
        salir.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void onClick(View v)
    {

        if (v.getId()==findViewById(R.id.actividad1).getId())
        {
            Intent intent = new Intent(this, Actividad1.class);

            startActivity(intent);
        }
        if (v.getId()==findViewById(R.id.actividad2).getId())
        {
            Intent intent = new Intent(this, Actividad2.class);

            startActivity(intent);
        }
        if (v.getId()==findViewById(R.id.actividad3).getId())
        {
            Intent intent = new Intent(this, Actividad3.class);

            startActivity(intent);
        }
        if (v.getId()==findViewById(R.id.actividad4).getId())
        {
            Intent intent = new Intent(this, Actividad4.class);

            startActivity(intent);
        }
        if (v.getId()==findViewById(R.id.actividad5).getId())
        {
            Intent intent = new Intent(this, Actividad5.class);

            startActivity(intent);
        }
        if (v.getId()==findViewById(R.id.salir).getId())
        {
            finish();
        }

    }
}
