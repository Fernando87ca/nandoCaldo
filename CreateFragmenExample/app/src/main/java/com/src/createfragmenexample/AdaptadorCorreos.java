package com.src.createfragmenexample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Fernando87ca on 13/06/2016.
 */
public class AdaptadorCorreos extends ArrayAdapter<Correo>
{
    private AppCompatActivity vistaLlamada;
    private ArrayList<Correo> listaCorreos = new ArrayList<Correo>();

    public AdaptadorCorreos(Context context, ArrayList<Correo> pListaCorreos)
    {
        super(context,R.layout.listado_correos,pListaCorreos);
        vistaLlamada = (AppCompatActivity)context;
        listaCorreos = pListaCorreos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        //logica del get view del adapter
        LayoutInflater inflater = vistaLlamada.getLayoutInflater();
        View vista = inflater.inflate(R.layout.correo,null);

        TextView de = (TextView)vista.findViewById(R.id.idDe);
        if(de != null)
            de.setText(listaCorreos.get(position).getDe());

        TextView asunto = (TextView)vista.findViewById(R.id.idAsunto);
        if(asunto != null)
            asunto.setText(listaCorreos.get(position).getAsunto());

        return vista;
    }
}
