package com.src.playingwithfragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import Fragmentos.FragmentoDetalleAnimal;
import Fragmentos.FragmentoListiadoAnimales;
import Fragmentos.fragmentos1;
import Fragmentos.fragmentos2;
import Fragmentos.fragmentos3;

public class Activity_Principal extends AppCompatActivity implements FragmentoListiadoAnimales.AnimalesLisener
{
    private DrawerLayout contenedorMenuIzquierdo;
    private NavigationView menuIzquierdo;
    boolean fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu_desplegable);
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        fragmentTransaction = false;

        //crearemos la accion para el menu desplegable lateral izquierdo
        contenedorMenuIzquierdo = (DrawerLayout)findViewById(R.id.menuIzquierdo);
        menuIzquierdo = (NavigationView)findViewById(R.id.navview);
        menuIzquierdo.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(MenuItem item)
            {
                fragmentTransaction = false;
                Fragment fragment = null;

                switch (item.getItemId())
                {
                    case R.id.menu_seccion_1:
                        fragment = new fragmentos1();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_seccion_2:
                        fragment = new fragmentos2();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_seccion_3:
                        fragment = new fragmentos3();
                        fragmentTransaction = true;
                        break;
                }

                if(fragmentTransaction)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
                    item.setChecked(true);
                    getSupportActionBar().setTitle(item.getTitle());
                }

                contenedorMenuIzquierdo.closeDrawers();
                return true;
            }
        });

        if(!fragmentTransaction)
        {
            FragmentoListiadoAnimales fragment = new FragmentoListiadoAnimales();
            fragment.setListener((FragmentoListiadoAnimales.AnimalesLisener) this);

            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
        }

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


    @Override
    public void onAnimalSeleccionado(Animal pAnimal)
    {
        //asigna en caso de ser nulo
        boolean hayDetalle = (this.getSupportFragmentManager().findFragmentById(R.id.idFragmentoDetalleAnimal)) != null;

        if(hayDetalle)
        {
            FragmentoDetalleAnimal fragmentById = (FragmentoDetalleAnimal) this.getSupportFragmentManager().findFragmentById(R.id.idFragmentoDetalleAnimal);
            fragmentById.mostrarDetalle(pAnimal.getIdImagen(),pAnimal.getNombre(),pAnimal.getDescripcion());
        }
        else
        {
            Intent detalleCorreo = new Intent(this,DetalleAnimal.class);

            detalleCorreo.putExtra("imagen",pAnimal.getIdImagen());
            detalleCorreo.putExtra("titulo",pAnimal.getNombre());
            detalleCorreo.putExtra("descripcion",pAnimal.getDescripcion());

            this.startActivity(detalleCorreo);
        }
    }
}
