package Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.menu2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmento2 extends Fragment
{
    public static Fragmento2 newInstance()
    {
        Fragmento2 fragment = new Fragmento2();
        return fragment;
    }

    public Fragmento2()
    {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_fragmento2, container, false);
    }

}
