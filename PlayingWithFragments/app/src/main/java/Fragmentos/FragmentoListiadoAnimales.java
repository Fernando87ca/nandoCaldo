package Fragmentos;

import android.content.Context;
import android.content.res.Resources;
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

import com.src.playingwithfragments.AdaptadorAnimales;
import com.src.playingwithfragments.Animal;
import com.src.playingwithfragments.R;

import java.util.ArrayList;

public class FragmentoListiadoAnimales extends Fragment
{
    private ArrayList<Animal> listaAnimales;
    private ListView listaVista;
    private AnimalesLisener listener;

    public FragmentoListiadoAnimales()
    {
        listaAnimales = new ArrayList<Animal>();
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        listaAnimales.add(new Animal(R.drawable.buho,"Buho",getString(R.string.sBuho)));
        listaAnimales.add(new Animal(R.drawable.colibri,"Colibri",getString(R.string.sColibri)));
        listaAnimales.add(new Animal(R.drawable.cuervo,"Cuervo",getString(R.string.sCuervo)));
        listaAnimales.add(new Animal(R.drawable.flamenco,"Flamenco",getString(R.string.sFlamenco)));
        listaAnimales.add(new Animal(R.drawable.kiwi,"Kiwi",getString(R.string.sKiwi)));
        listaAnimales.add(new Animal(R.drawable.loro,"Loro",getString(R.string.sLoro)));
        listaAnimales.add(new Animal(R.drawable.pavo,"Pavo",getString(R.string.sPavo)));
        listaAnimales.add(new Animal(R.drawable.pingu,"Pingüino",getString(R.string.sPing)));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.listview_lista_animales, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        listaVista = (ListView)getView().findViewById(R.id.idListadoXML);
        AdaptadorAnimales adaptadorAnimales = new AdaptadorAnimales(getView().getContext(),listaAnimales);
        listaVista.setAdapter(adaptadorAnimales);

        listaVista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if(listener != null)
                {
                    listener.onAnimalSeleccionado((Animal)listaVista.getAdapter().getItem(position));
                }
            }
        });
    }


    //Interfaz para transmitir datos entreactivities y fragments
    public interface AnimalesLisener
    {
        void onAnimalSeleccionado(Animal pAnimal);
    }

    public void setListener(AnimalesLisener listener)
    {
        this.listener = listener;
    }
}
