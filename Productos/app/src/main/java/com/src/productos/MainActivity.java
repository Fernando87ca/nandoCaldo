package com.src.productos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity
{
    private EditText codigo;
    private EditText descripcio;
    private EditText precio;

    //Intentar moverlo a otra clase
    private Operaciones operacion;

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

        codigo = (EditText)findViewById(R.id.idCodigo);
        descripcio = (EditText)findViewById(R.id.idDescripcion);
        precio = (EditText)findViewById(R.id.idPrecio);

        operacion = new Operaciones();
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

    public void Alta(View v)
    {
        if(!(codigo.getText().toString().isEmpty())&&!(descripcio.getText().toString().isEmpty())&&!(precio.getText().toString().isEmpty()))
        {
            String retorno = operacion.addProduct(this.getApplicationContext(),Integer.parseInt(codigo.getText().toString()),descripcio.getText().toString(),Float.parseFloat(precio.getText().toString()));
            Toast.makeText(this,retorno, Toast.LENGTH_SHORT).show();
            codigo.setText("");
            descripcio.setText("");
            precio.setText("");
        }
        else
            Toast.makeText(MainActivity.this,"No pueden haber campos nulos en una Alta", Toast.LENGTH_SHORT).show();
    }

    public void ConsultaPorCodigo(View v)
    {
        String id = codigo.getText().toString();
        if(id.isEmpty())
            Toast.makeText(this.getApplicationContext(),"ID no puede ser nulo",Toast.LENGTH_SHORT).show();
        else
        {
            Map<String,String> rst = operacion.selectByCode(this.getApplicationContext(), Integer.parseInt(id));
            if (!(rst.isEmpty()))
            {
                descripcio.setText(rst.get("descripcion"));
                precio.setText(rst.get("precio"));
                Toast.makeText(MainActivity.this, "Valores Recuperados", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(MainActivity.this, "No hay ningun valor para este ID", Toast.LENGTH_SHORT).show();
        }
    }

    public void ConsultaPorDescripcion(View v)
    {
        String desc = this.descripcio.getText().toString();
        if (desc.isEmpty())
            Toast.makeText(MainActivity.this, "Descripcion nula", Toast.LENGTH_SHORT).show();
        else
        {
            Intent pantallaResultados = new Intent(this,PantallaResultados.class);
            pantallaResultados.putExtra("descripcion",desc);
            startActivity(pantallaResultados);
        }
    }

    public void BajaPorCodigo(View v)
    {
        String id = codigo.getText().toString();
        if(id.isEmpty())
            Toast.makeText(this.getApplicationContext(),"ID no puede ser nulo",Toast.LENGTH_SHORT).show();
        else
        {
            this.operacion.bajaPorCodigo(this.getApplicationContext(), Integer.parseInt(id));
            this.codigo.setText("");
            this.descripcio.setText("");
            this.precio.setText("");

            Toast.makeText(this, "Producto Eliminado", Toast.LENGTH_SHORT).show();
        }
    }

    public void Modificacion(View v)
    {
        if(!(codigo.getText().toString().isEmpty())&&!(descripcio.getText().toString().isEmpty())&&!(precio.getText().toString().isEmpty()))
        {
            String retorno = operacion.addProduct(this,Integer.parseInt(codigo.getText().toString()),descripcio.getText().toString(),Float.parseFloat(precio.getText().toString()));
            Toast.makeText(this,retorno, Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(MainActivity.this,"No pueden haber campos nulos en una Modificacion", Toast.LENGTH_SHORT).show();
    }
}
