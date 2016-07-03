package com.src.productos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


import java.util.ArrayList;

public class PantallaResultados extends AppCompatActivity
{
    private EditText titulo;
    private ListView listaResultados;
    private Operaciones operacion;
    private ArrayList<ArrayList<String>> Resultados;

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

        operacion = new Operaciones();
        listaResultados = (ListView)findViewById(R.id.idListaResultados);
        Bundle bundle = getIntent().getExtras();
        ArrayList<ArrayList<String>> Resultados = operacion.selectByDesc(this.getApplicationContext(), bundle.getString("descripcion"));

        ArrayList<String> mostrados = new ArrayList<>();
        for(ArrayList<String> linia: Resultados)
        {
            mostrados.add("ID: " + linia.get(0) +" Desc: "+ linia.get(1) + " Precio: "+linia.get(2));
        }
        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,mostrados);
        listaResultados.setAdapter(adaptador);
    }


}
