package com.src.cuartoejemplo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private TextView pregunta;
    private EditText entraTexto;
    private Button boton;
    int valorAleatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
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

        //Recogemos elementos del frontal
        pregunta = (TextView)findViewById(R.id.pregunta);
        entraTexto = (EditText)findViewById(R.id.entraTexto);
        boton = (Button)findViewById(R.id.boton);

        //Abrimos durante unos segundos el cuadro de texto
        valorAleatorio = (int)(Math.random()*100001);
        Toast tostada = Toast.makeText(this,String.valueOf(valorAleatorio),Toast.LENGTH_LONG);
        tostada.show();
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

    public void InsertarValor(View v)
    {
        String valorIntroducido = String.valueOf(entraTexto.getText());
        Toast segundaTostada;

        if (Integer.parseInt(valorIntroducido)==valorAleatorio)
            segundaTostada = Toast.makeText(this,"ah ah ah, SI has dicho la palabra magica",Toast.LENGTH_LONG);
        else
            segundaTostada = Toast.makeText(this,"ah ah ah, NO has dicho la palabra magica",Toast.LENGTH_LONG);
        segundaTostada.show();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
