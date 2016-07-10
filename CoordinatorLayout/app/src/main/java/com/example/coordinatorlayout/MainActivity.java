package com.example.coordinatorlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView recView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //appbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        //iniciacion de los datos que pondremos en la pantalla
        ArrayList<Titular> datos = new ArrayList<>();
        for(int i=0; i<50; i++)
        {
            datos.add(new Titular("Título " + i, "Subtítulo item " + i));
        }

        //Inicialización RecyclerView
        recView = (RecyclerView) findViewById(R.id.RecView);
        recView.setHasFixedSize(true);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(datos);
        adaptador.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(),String.valueOf(recView.getChildPosition(v)),Toast.LENGTH_SHORT).show();
            }
        });

        recView.setAdapter(adaptador);
        recView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //recView.setLayoutManager(new GridLayoutManager(this,3));
        recView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        recView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
