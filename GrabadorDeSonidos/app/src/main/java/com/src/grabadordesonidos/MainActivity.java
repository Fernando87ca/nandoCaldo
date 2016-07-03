package com.src.grabadordesonidos;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
{
    private int peticion = 1;
    private Uri url1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void grabar(View v)
    {
        Intent sendIntent = new Intent(Intent.ACTION_SEND);

        Intent alarma = new Intent(AlarmClock.ACTION_SET_ALARM).putExtra(AlarmClock.EXTRA_HOUR,)

        //Intent intent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
        //startActivityForResult(intent, peticion);
    }

    public void reproducir(View v)
    {
       // MediaPlayer mediaPlayer = MediaPlayer.create(this, url1);
        //mediaPlayer.start();

        Resources res = this.getApplication().getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.locale = new Locale("de", "DE");
        res.updateConfiguration(conf, dm);

        String hola = this.getApplication().getResources().getConfiguration().locale.getDisplayCountry();

        System.out.println("esto es lo que he recogido -->> "+hola);
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data)
    {
        if (resultCode == RESULT_OK && requestCode == peticion)
        {
            url1 = data.getData();
            System.out.println(url1);
        }
    }
}
