package com.src.ejercicio14;

import android.os.Bundle;
import android.os.Environment;
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity
{
    private EditText notaIngresada;
    private EditText notepad;

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

        notepad = (EditText)findViewById(R.id.notepad);
        notaIngresada = (EditText)findViewById(R.id.IngresarNota);

        //Utilizando InputStreamReader y BufferedReader leer fichero y añadirlo al texto
        //miramos todos los Txt que hemos creado (en este caso 0 o 1)

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

    public void Recuperar(View v)
    {
        String[] archivos = fileList();

        String nota = notaIngresada.getText().toString();

        if (!(nota.isEmpty()))
        {
            nota = nota.replace("/","-");
            //en vez de pasar una nota fija, pasamos el nombre de la nota que haya escrito
            try
            {
                this.leerArchivo(nota);
            }
            catch (Exception e)
            {
                Toast.makeText(this,"imposible abrir el archivo "+nota,Toast.LENGTH_SHORT).show();
            }
        }
        else
            Toast.makeText(this,"Ingrese Fecha",Toast.LENGTH_SHORT).show();
    }

    /* Para este ejecicio no se coprobara si la nota existe
    public boolean existe(String[] pArchivos,String pFichero)
    {
        for(int f=0; f<pArchivos.length;f++)
            if(pArchivos[f].compareTo(pFichero)==0)
                return true;
        return false;
    } */

    private void leerArchivo(String nota) throws IOException
    {
        //implementamos la lectura de la tarjeta
        File tarjetaPath = Environment.getExternalStorageDirectory();
        File tarjeta = new File(tarjetaPath.getAbsolutePath(),nota);

        InputStreamReader archivo = new InputStreamReader(new FileInputStream(tarjeta));
        BufferedReader br = new BufferedReader(archivo);
        String linia = br.readLine();
        String texto = "";
        while(linia != null)
        {
            texto += linia + "\n";
            linia = br.readLine();
        }
        br.close();
        archivo.close();
        this.notepad.setText(texto);
    }

    public void grabar(View v)
    {
        try
        {
            //Recuperamos la nota que tratamos de guardar
            String tituloArchivo = this.notaIngresada.getText().toString();

            if(!(tituloArchivo.isEmpty()))
            {
                //habrimos la conexion contra la Memoria interna y declaramos la tarjeta de memoria
                File tarjetaPath = Environment.getExternalStorageDirectory();
                File tarjeta = new File(tarjetaPath.getAbsoluteFile(),tituloArchivo);
                tarjeta.createNewFile();

                //El nombre del archivo a abrir es la fecha de la nota
                OutputStreamWriter archivo = new OutputStreamWriter(new FileOutputStream(tarjeta));
                archivo.write(notepad.getText().toString());
                archivo.flush();
                archivo.close();
                Toast.makeText(MainActivity.this,"Nota insertada",Toast.LENGTH_SHORT).show();
                this.finish();
            }
            else
                Toast.makeText(this,"Ingrese Fecha",Toast.LENGTH_SHORT).show();
        }
        catch (FileNotFoundException e)
        {
            Toast.makeText(MainActivity.this, "Imposible abrir el fichero", Toast.LENGTH_SHORT).show();
        } catch (IOException e)
        {
            Toast.makeText(MainActivity.this, "No se puede guardar la nota", Toast.LENGTH_SHORT).show();
        }
    }
}
