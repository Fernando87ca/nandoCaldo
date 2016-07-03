package com.src.ejercicio13;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PantallaResultados extends AppCompatActivity
{
    private Button volver;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_resultados);
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

        this.volver = (Button)findViewById(R.id.volver);
        this.lista = (ListView)findViewById(R.id.listaPersonas);

        ArrayList<String> listaFinal = takeList();

        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaFinal);
        this.lista.setAdapter(adapter);
    }

    @NonNull
    private ArrayList<String> takeList()
    {
        SharedPreferences agenda = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        Map<String, String> mapaResultados = (Map<String, String>) agenda.getAll();
        Set<String> claves = mapaResultados.keySet();
        ArrayList<String> listaFinal = new ArrayList<String>();

        for (String clave : claves)
        {
            listaFinal.add("Nombre: " + clave + " Telf: " + mapaResultados.get(clave));
        }
        return listaFinal;
    }

    public void volver(View v)
    {
        finish();
    }

}
