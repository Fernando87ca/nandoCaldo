package com.src.playingwithfragments;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class AdaptadorAnimales extends ArrayAdapter<Animal>
{
    private AppCompatActivity vistaLlamada;
    private ArrayList<Animal> listaAnimales = new ArrayList<Animal>();

    public AdaptadorAnimales(Context context, ArrayList<Animal> pListaAnimales)
    {
        super(context,R.layout.listview_lista_animales,pListaAnimales);
        vistaLlamada = (AppCompatActivity)context;
        listaAnimales = pListaAnimales;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = vistaLlamada.getLayoutInflater();
        View vista = inflater.inflate(R.layout.detalle_animal, null);

        ImageView foto = (ImageView)vista.findViewById(R.id.idImagenAnimal);
        if(foto != null)
            foto.setImageResource(listaAnimales.get(position).getIdImagen());

        TextView nombreAnimal = (TextView) vista.findViewById(R.id.idNombreAnimal);
        if(nombreAnimal != null)
            nombreAnimal.setText(listaAnimales.get(position).getNombre());


        return vista;
    }
}
