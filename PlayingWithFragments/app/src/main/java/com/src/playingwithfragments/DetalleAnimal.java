package com.src.playingwithfragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import layout.FragmentoDetalleAnimal;

public class DetalleAnimal extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.fragmento_detalle_animal);

        int imagenAnimal = getIntent().getExtras().getInt("imagen");
        String tituloAnimal = getIntent().getExtras().getString("titulo");
        String descripcionAnimal = getIntent().getExtras().getString("descripcion");

        FragmentoDetalleAnimal fragmentoDetalle = (FragmentoDetalleAnimal)getSupportFragmentManager().findFragmentById(R.id.idFragmentoDetalleAnimal);
        fragmentoDetalle.mostrarDetalle(imagenAnimal,tituloAnimal,descripcionAnimal);
    }
}
