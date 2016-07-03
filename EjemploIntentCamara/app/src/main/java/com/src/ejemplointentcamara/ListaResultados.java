package com.src.ejemplointentcamara;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;

public class ListaResultados extends AppCompatActivity
{
    private ListView listaFotosResultado;
    private ImageView muestraPrevia;
    private String[] listaDeFicheros;
    private ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_resultados);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        muestraPrevia = (ImageView)findViewById(R.id.idFotoPreview);
        listaFotosResultado = (ListView)findViewById(R.id.idListaFotosResultado);

        File directorioFotos = getExternalFilesDir(null);
        if(directorioFotos.exists())
        {
            listaDeFicheros = directorioFotos.list();

            adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,listaDeFicheros);
            listaFotosResultado.setAdapter(adaptador);

            //Creamos el evento on click del ListView
            listaFotosResultado.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    Bitmap fotoRecuperada = BitmapFactory.decodeFile(getExternalFilesDir(null)+"/"+listaDeFicheros[position]);
                    muestraPrevia.setImageBitmap(fotoRecuperada);
                }
            });
        }
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
