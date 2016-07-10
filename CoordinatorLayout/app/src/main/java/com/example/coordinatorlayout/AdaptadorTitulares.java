package com.example.coordinatorlayout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class AdaptadorTitulares extends RecyclerView.Adapter<TitularesViewHolder> implements View.OnClickListener
{
    private ArrayList<Titular> datos;
    private View.OnClickListener listener;

    public AdaptadorTitulares(ArrayList<Titular> pDatos)
    {
        this.datos = pDatos;
    }

    @Override
    public TitularesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View vista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem_titular,viewGroup,false);
        vista.setOnClickListener(this);
        TitularesViewHolder titularesVH = new TitularesViewHolder(vista);
        return titularesVH;
    }

    @Override
    public void onBindViewHolder(TitularesViewHolder titularesViewHolde, int i)
    {
        Titular item = datos.get(i);
        titularesViewHolde.bindTitular(item);
    }

    @Override
    public int getItemCount()
    {
        return datos.size();
    }

    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener = listener;
    }

    //Metodo importado de la clase View
    @Override
    public void onClick(View v)
    {
        if(listener != null)
        {
            listener.onClick(v);
        }
    }
}
