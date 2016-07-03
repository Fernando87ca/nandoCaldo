package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.src.createfragmenexample.AdaptadorCorreos;
import com.src.createfragmenexample.Correo;
import com.src.createfragmenexample.R;

import java.util.ArrayList;


public class FragmentoListadoCorreos extends Fragment
{

    private ListView listadoCorreos;
    private ArrayList<Correo> listaCorreos = new ArrayList<Correo>();
    private CorreosListener listener;

    public FragmentoListadoCorreos()
    {
        //Iniciaremos la lista aqui
        listaCorreos.add(new Correo("Persona 1", "Asunto del correo 1", "Texto del correo 1"));
        listaCorreos.add(new Correo("Persona 2", "Asunto del correo 2", "Texto del correo 2"));
        listaCorreos.add(new Correo("Persona 3", "Asunto del correo 3", "Texto del correo 3"));
        listaCorreos.add(new Correo("Persona 4", "Asunto del correo 4", "Texto del correo 4"));
        listaCorreos.add(new Correo("Persona 5", "Asunto del correo 5", "Texto del correo 5"));
        listaCorreos.add(new Correo("Persona 6", "Asunto del correo 6", "Texto del correo 6"));
        listaCorreos.add(new Correo("Persona 7", "Asunto del correo 7", "Texto del correo 7"));
        listaCorreos.add(new Correo("Persona 8", "Asunto del correo 8", "Texto del correo 8"));

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    //equivalente al onCreate de una activity
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.listado_correos, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        listadoCorreos = (ListView) getView().findViewById(R.id.idListadoCorreos);
        AdaptadorCorreos adapter = new AdaptadorCorreos(getView().getContext(),listaCorreos);
        listadoCorreos.setAdapter(adapter);

        listadoCorreos.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> list, View view, int pos, long id)
            {
                if (listener!=null)
                {
                    listener.onCorreoSeleccionado((Correo)listadoCorreos.getAdapter().getItem(pos));
                }
            }
        });
    }


    public interface CorreosListener
    {
        void onCorreoSeleccionado(Correo c);
    }

    public void setCorreosListener(CorreosListener listener)
    {
        this.listener = listener;
    }
}
