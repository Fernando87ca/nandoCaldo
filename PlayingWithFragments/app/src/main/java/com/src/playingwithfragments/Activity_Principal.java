package com.src.playingwithfragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import layout.FragmentoDetalleAnimal;
import layout.FragmentoListiadoAnimales;

public class Activity_Principal extends AppCompatActivity implements FragmentoListiadoAnimales.AnimalesLisener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu_desplegable);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentoListiadoAnimales fragmentoListaAnimales = (FragmentoListiadoAnimales) this.getSupportFragmentManager().findFragmentById(R.id.idFragmentoListadoAnimales);
        fragmentoListaAnimales.setListener((FragmentoListiadoAnimales.AnimalesLisener) this);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onAnimalSeleccionado(Animal pAnimal)
    {
        //asigna en caso de ser nulo
        boolean hayDetalle = (this.getSupportFragmentManager().findFragmentById(R.id.idFragmentoDetalleAnimal)) != null;

        if(hayDetalle)
        {
            FragmentoDetalleAnimal fragmentById = (FragmentoDetalleAnimal) this.getSupportFragmentManager().findFragmentById(R.id.idFragmentoDetalleAnimal);
            fragmentById.mostrarDetalle(pAnimal.getIdImagen(),pAnimal.getNombre(),pAnimal.getDescripcion());
        }
        else
        {
            Intent detalleCorreo = new Intent(this,DetalleAnimal.class);

            detalleCorreo.putExtra("imagen",pAnimal.getIdImagen());
            detalleCorreo.putExtra("titulo",pAnimal.getNombre());
            detalleCorreo.putExtra("descripcion",pAnimal.getDescripcion());

            this.startActivity(detalleCorreo);
        }
    }
}
