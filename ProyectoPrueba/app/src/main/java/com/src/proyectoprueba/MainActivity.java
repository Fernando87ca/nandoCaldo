package com.src.proyectoprueba;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    //Si no encontrara la clase Alt + Enter te importa las librerias que faltan.
    private EditText et1, et2;
    private TextView tv3;
    private Spinner spinner;
    //private RadioButton r1, r2;
    //private CheckBox ch1, ch2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Hacemos que JAVA reconozca las variables del XML
        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        tv3 = (TextView)findViewById(R.id.tv3);

        spinner = (Spinner)findViewById(R.id.sp);
        String [] opciones = {"Sumar","Restar","Multiplicar","Dividir","Modulo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spinner.setAdapter(adapter);

        //r1 = (RadioButton)findViewById(R.id.r1);
        //r2 = (RadioButton)findViewById(R.id.r2);
        //ch1 = (CheckBox)findViewById(R.id.ch1);
        //ch2 = (CheckBox)findViewById(R.id.ch2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /** ************ METODOS CREADOS POR NOSOTROS ********** */
    public void Operar(View vista)
    {
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        int valor3=0;
        String texto="";

        //Recolectamos el valor que el usuario ha marcado en el spinner
        String seleccionada = spinner.getSelectedItem().toString();

        //Si es sumar
        if(seleccionada.compareTo("Sumar")==0)
        {
            valor3 = Integer.parseInt(valor1) + Integer.parseInt(valor2);
            texto = "El valor de la Suma es: "+valor3;
        }

        //Si es restar
        if(seleccionada.compareTo("Restar")==0)
        {
            valor3 = Integer.parseInt(valor1) - Integer.parseInt(valor2);
            texto = "El valor de la Resta es: "+valor3;
        }

        //Si es multiplicar
        if(seleccionada.compareTo("Multiplicar")==0)
        {
            valor3 = Integer.parseInt(valor1) * Integer.parseInt(valor2);
            texto = "El valor de la Multiplicación es: "+valor3;
        }

        //Si es dividir
        if(seleccionada.compareTo("Dividir")==0)
        {
            valor3 = Integer.parseInt(valor1) / Integer.parseInt(valor2);
            texto = "El valor de la Division es: "+valor3;
        }

        //Si es mod
        if(seleccionada.compareTo("Modulo")==0)
        {
            valor3 = Integer.parseInt(valor1) % Integer.parseInt(valor2);
            texto = "El valor del Modulo es: "+valor3;
        }

        tv3.setText(texto);
    }
}
