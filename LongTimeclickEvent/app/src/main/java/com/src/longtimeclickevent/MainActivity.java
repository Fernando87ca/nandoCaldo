package com.src.longtimeclickevent;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity
{
    private EditText textoInsertado;
    private EditText telefonoInsertado;
    private ListView lista;
    private ArrayList<String> telefonos;
    private ArrayAdapter<String> adaptador;
    private SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textoInsertado = (EditText)findViewById(R.id.idNombreIntroducido);
        telefonoInsertado = (EditText)findViewById(R.id.idTelefono);
        lista = (ListView)findViewById(R.id.idLista);

        telefonos = new ArrayList<String>();
        this.cargarDatos();

        adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,telefonos);
        lista.setAdapter(adaptador);

        //vamos a declarar el evento on longclick
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
            {
                final int posicion = position;

                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Importante");
                dialogo.setMessage("¿ Elimina este teléfono ?");
                dialogo.setCancelable(false);
                dialogo.setPositiveButton("Confirmar",new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialogo1, int id)
                    {
                        String mensage = telefonos.get(posicion);
                        StringTokenizer fragmento = new StringTokenizer(mensage," : ");
                        String clave = fragmento.nextToken().trim();
                        SharedPreferences.Editor elemento = preferencias.edit();
                        elemento.remove(clave);
                        elemento.commit();

                        //Aqui lo eliminamos de la vista
                        telefonos.remove(posicion);
                        adaptador.notifyDataSetChanged();
                    }
                });
                dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialogo1, int id)
                    {
                        Toast.makeText(MainActivity.this, "Borrado Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                dialogo.show();

                return false;
            }
        });
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

    private void cargarDatos()
    {
        preferencias = getSharedPreferences("datosDePersonas", Context.MODE_PRIVATE);
        Map<String, ?> valores = preferencias.getAll();
        for (Map.Entry<String, ?> valor : valores.entrySet())
        {
            this.telefonos.add(valor.getKey()+" : "+valor.getValue());
        }

    }

    public void addContact(View v)
    {
        telefonos.add(textoInsertado.getText().toString()+" : "+telefonoInsertado.getText().toString());

        //el notifica al adaptador para que se recargue, en el evento on change ya esta lincado con la array
        adaptador.notifyDataSetChanged();
        this.textoInsertado.setText("");
        this.telefonoInsertado.setText("");

        SharedPreferences.Editor elemento=preferencias.edit();
        elemento.putString(textoInsertado.getText().toString(),telefonoInsertado.getText().toString());
        elemento.commit();
    }
}