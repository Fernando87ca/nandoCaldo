package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.src.playingwithfragments.R;

public class FragmentoDetalleAnimal extends Fragment
{
    private ImageView fotoAnimal;
    private TextView tituloAnimal;
    private TextView animalDetalle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //no se asocia al fragmento sino al xml que compondra el fragmento
        return inflater.inflate(R.layout.detalle_animal_expandido, container, false);
    }

    public void mostrarDetalle(int idImagen, String nombre, String pDescripcion)
    {
        /*LayoutInflater inflater = vistaLlamada.getLayoutInflater();
        View vista = inflater.inflate(R.layout.detalle_animal, null);*/

        ImageView foto = (ImageView)getView().findViewById(R.id.idImagenAnimal);
        if(foto != null)
            foto.setImageResource(idImagen);

        TextView nombreAnimal = (TextView) getView().findViewById(R.id.idNombreAnimal);
        if(nombreAnimal != null)
            nombreAnimal.setText(nombre);

        TextView descripcionAnimal = (TextView) getView().findViewById(R.id.idDescripcionAnimal);
        if(descripcionAnimal != null)
            descripcionAnimal.setText(pDescripcion);
    }
}
