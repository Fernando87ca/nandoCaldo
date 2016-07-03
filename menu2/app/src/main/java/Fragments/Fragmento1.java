package Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.menu2.R;

public class Fragmento1 extends Fragment
{
    public static Fragmento1 newInstance()
    {
        Fragmento1 fragment = new Fragmento1();
        return fragment;
    }

    public Fragmento1()
    {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_fragmento1, container, false);
    }

}
