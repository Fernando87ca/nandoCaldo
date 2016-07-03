package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.src.createfragmenexample.R;


public class FragmentoDetalle extends Fragment
{
    private TextView textoDetalle;

    public FragmentoDetalle()
    {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.detalle_correo, container, false);
    }

    public void mostrarDetalle(String pTexto)
    {
        textoDetalle = (TextView)getView().findViewById(R.id.idTextoDetalle);
        textoDetalle.setText(pTexto);
    }
}
