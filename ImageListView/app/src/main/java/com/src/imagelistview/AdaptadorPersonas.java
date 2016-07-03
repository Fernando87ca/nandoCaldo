package com.src.imagelistview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorPersonas extends ArrayAdapter<Persona>
{
    AppCompatActivity appCompatActivity;
    private ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

    public AdaptadorPersonas(Context context, ArrayList<Persona> pListaPersonas)
    {
        super(context,R.layout.persona,pListaPersonas);
        appCompatActivity = (AppCompatActivity) context;
        listaPersonas = pListaPersonas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = appCompatActivity.getLayoutInflater();
        View item = inflater.inflate(R.layout.persona, null);

        ImageView foto = (ImageView)item.findViewById(R.id.idFoto);
        if(listaPersonas.get(position).getGenero() == 'm')
            foto.setImageResource(R.mipmap.hombre);
        else if(listaPersonas.get(position).getGenero() == 'f')
            foto.setImageResource(R.mipmap.mujer);

        TextView nombre = (TextView)item.findViewById(R.id.idPersona);
        nombre.setText(listaPersonas.get(position).getNombre());

        return item;
    }
}
