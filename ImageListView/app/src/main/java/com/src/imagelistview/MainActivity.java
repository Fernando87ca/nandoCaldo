package com.src.imagelistview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private ArrayList<Persona> listaPersonas;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.listaPersonas = new ArrayList<Persona>();
        listaPersonas.add(new Persona("Juan", 'm'));
        listaPersonas.add(new Persona("pedro",'m'));
        listaPersonas.add(new Persona("luis",'m'));
        listaPersonas.add(new Persona("ana",'f'));
        listaPersonas.add(new Persona("carla",'f'));
        listaPersonas.add(new Persona("maria",'f'));
        listaPersonas.add(new Persona("gustavo",'m'));
        listaPersonas.add(new Persona("carlos",'m'));
        listaPersonas.add(new Persona("marta",'f'));
        listaPersonas.add(new Persona("luisa",'f'));
        listaPersonas.add(new Persona("fernanda",'f'));
        listaPersonas.add(new Persona("jose",'m'));
        listaPersonas.add(new Persona("caldo",'m'));
        listaPersonas.add(new Persona("dulan",'m'));
        listaPersonas.add(new Persona("lafa",'m'));
        listaPersonas.add(new Persona("cinta",'f'));
        listaPersonas.add(new Persona("bartolo",'m'));
        listaPersonas.add(new Persona("gemma",'f'));
        listaPersonas.add(new Persona("maar",'f'));

        AdaptadorPersonas adaptador = new AdaptadorPersonas(this,listaPersonas);
        lista = (ListView)findViewById(R.id.idLista);
        lista.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menuopciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id==R.id.telefono)
        {
            Toast.makeText(this,R.string.telefono,Toast.LENGTH_LONG).show();
        }
        if(id==R.id.camara)
        {
            Toast.makeText(this,R.string.camara,Toast.LENGTH_LONG).show();
        }
        if (id==R.id.opcion1)
        {
            Toast.makeText(this,R.string.mensaje_1,Toast.LENGTH_LONG).show();
        }
        if (id==R.id.opcion2)
        {
            Toast.makeText(this,R.string.mensaje_2,Toast.LENGTH_LONG).show();
        }
        if (id==R.id.opcion3)
        {
            Toast.makeText(this,R.string.mensaje_3, Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
