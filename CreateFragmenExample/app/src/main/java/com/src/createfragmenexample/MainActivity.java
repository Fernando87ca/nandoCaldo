package com.src.createfragmenexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import layout.FragmentoDetalle;
import layout.FragmentoListadoCorreos;

public class MainActivity extends AppCompatActivity implements FragmentoListadoCorreos.CorreosListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentoListadoCorreos fragmentoListado = (FragmentoListadoCorreos)this.getSupportFragmentManager().findFragmentById(R.id.idFragmentoListadoCorreos);
        fragmentoListado.setCorreosListener((FragmentoListadoCorreos.CorreosListener) this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCorreoSeleccionado(Correo c)
    {
        //asigna en caso de ser nulo
        boolean hayDetalle = (this.getSupportFragmentManager().findFragmentById(R.id.idFragmentoDetalle)) != null;

        if(hayDetalle)
        {
            FragmentoDetalle fragmentById = (FragmentoDetalle) this.getSupportFragmentManager().findFragmentById(R.id.idFragmentoDetalle);
            fragmentById.mostrarDetalle(c.getTexto());
        }
        else
        {
            Intent detalleCorreo = new Intent(this,DetalleActivity.class);
            detalleCorreo.putExtra("Contenido",c.getTexto());
            this.startActivity(detalleCorreo);
        }
    }
}
