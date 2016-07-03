package com.src.ejercicio13;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity
{
    private EditText nombre, phone;
    private Button guardar, recuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Recuperamos lo que necesitemos
        nombre = (EditText)findViewById(R.id.nombre);
        phone = (EditText)findViewById(R.id.phone);
        guardar = (Button)findViewById(R.id.guardar);
        recuperar = (Button)findViewById(R.id.recuperar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setPhone(View v)
    {
        SharedPreferences agenda = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String name = this.nombre.getText().toString();
        String telefono = this.phone.getText().toString();

        //No pueden haber campos vacios
        if((name.compareTo("")==0)||(telefono.compareTo("")==0))
        {
            Toast tostada = Toast.makeText(this, "No pueden haber campos nulos",Toast.LENGTH_SHORT);
            tostada.show();
        }
        else
        {
            try
            {
                this.AddNewContact(agenda, name, telefono);
            }
            catch(Exception e)
            {
                Toast.makeText(this, "Imposible añadir nuevo Contacto", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void AddNewContact(SharedPreferences agenda, String name, String telefono)
    {
        //comprobar si existia o es nuevo
        try
        {
            if (((Map<String, String>) agenda.getAll()).get(name).compareTo("") != 0)
                Toast.makeText(this, "Registro Updateado", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            Toast.makeText(this, "Registro Nuevo", Toast.LENGTH_SHORT).show();
        }

        //Insertarmos valor
        SharedPreferences.Editor editor = agenda.edit();
        editor.putString(name,telefono);
        editor.commit();

        //limpiamos los campos
        this.nombre.setText("");
        this.phone.setText("");
    }

    public void getPhone(View v)
    {
        Intent pantallaResultados = new Intent(this,PantallaResultados.class);
        startActivity(pantallaResultados);
    }
}
