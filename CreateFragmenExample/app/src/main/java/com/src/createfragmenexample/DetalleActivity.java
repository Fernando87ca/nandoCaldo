package com.src.createfragmenexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import layout.FragmentoDetalle;

public class DetalleActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.fragmento_detalle_correo);

        String contenido = getIntent().getExtras().getString("Contenido");

        FragmentoDetalle fragmentoDetalle = (FragmentoDetalle)getSupportFragmentManager().findFragmentById(R.id.idFragmentoDetalle);
        fragmentoDetalle.mostrarDetalle(contenido);
    }
}
