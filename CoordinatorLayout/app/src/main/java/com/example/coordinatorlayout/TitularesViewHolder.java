package com.example.coordinatorlayout;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class TitularesViewHolder extends RecyclerView.ViewHolder
{
    private TextView txtTitulo;
    private TextView txtSubtitulo;

    public TitularesViewHolder(View itemView)
    {
        super(itemView);

        txtTitulo = (TextView)itemView.findViewById(R.id.LblTitulo);
        txtSubtitulo = (TextView)itemView.findViewById(R.id.LblSubTitulo);
    }

    public void bindTitular(Titular t)
    {
        txtTitulo.setText(t.getTitulo());
        txtSubtitulo.setText(t.getSubtitulo());
    }
}
