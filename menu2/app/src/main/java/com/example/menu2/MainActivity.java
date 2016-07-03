package com.example.menu2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import Fragments.FragmentAdaptadorPagina;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Appbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Spinner nandoToolBar = (Spinner)findViewById(R.id.NandoToolbar);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getSupportActionBar().getThemedContext(),R.layout.appbar_filter_title,new String[]{"Opción 1 ", "Opción 2 ", "Opción 3 "});
        adapter.setDropDownViewResource(R.layout.appbar_filter_list);
        nandoToolBar.setAdapter(adapter);

        nandoToolBar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Log.i("NandoToolBar","Seleccionada opction: "+position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {}
        });

        ViewPager submenu = (ViewPager)findViewById(R.id.viewpager);
        FragmentAdaptadorPagina adaptador = new FragmentAdaptadorPagina(getSupportFragmentManager());
        submenu.setAdapter(adaptador);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.appbartabs);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(submenu);
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
