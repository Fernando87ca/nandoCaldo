package Fragments;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAdaptadorPagina extends FragmentPagerAdapter
{
    final int PAGE_COUNT = 6;
    private String tabTitles[] = new String[] { "Tab Uno", "Tab Dos", "Tab Tres", "Tab Cuatro", "Tab Cinco", "Tab Seis"};

    public FragmentAdaptadorPagina(FragmentManager pFragmentManager)
    {
        super(pFragmentManager);
    }

    @Override
    public Fragment getItem(int position)
    {
        Fragment fragmento = null;

        switch (position)
        {
            case 0:
            case 2:
            case 4:
                fragmento = Fragmento1.newInstance();
                break;
            case 1:
            case 3:
            case 5:
                fragmento = Fragmento2.newInstance();
                break;
        }
        return fragmento;
    }


    @Override
    public int getCount()
    {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return tabTitles[position];
    }
}
