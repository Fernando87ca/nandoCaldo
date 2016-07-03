package com.src.ejemplomedia;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private String reproduciendo;
    private int posicion;
    private MediaPlayer mp;
    private Button circular;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circular = (Button)findViewById(R.id.idCircular);
        Toast.makeText(this.getApplicationContext(),circular.getText().toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Metodo que mata el reproductor
    public void destruir()
    {
        if(mp != null)
        {
            //libera el objeto media
            mp.release();
        }
    }

    //inicia nuevo audio desde 0
    public void iniciarAudio(View v)
    {
        this.destruir();
        mp = MediaPlayer.create(this.getApplicationContext(),R.raw.gato);
        mp.start();

        //miramos si esta en modo circular
        if (circular.getText().toString().compareTo("No Reproducir de Forma Circular")==0)
            mp.setLooping(false);
        else
            mp.setLooping(true);
    }

    //pausa audio guardado donde se paro
    public void pausarAudio(View v)
    {
        //si el objeto media esta creado y se esta reproduciendo entonces se puede pausar
        if ((mp != null) && (mp.isPlaying()))
        {
            this.posicion = mp.getCurrentPosition();
            mp.pause();
        }
    }

    //continua audio desde el punto en que se pauso
    public void continuarAudio(View v)
    {
        if((mp !=null)&&(mp.isPlaying()==false))
        {
            this.mp.seekTo(posicion);
            mp.start();
        }
    }

    //detiene el audio por completo sin guardar donde se quedo, no lo mataremos porque asi le podremos dar a continuar pero empezando de 0
    public void detenerAudio(View v)
    {
        if (mp != null)
        {
            this.posicion = 0;
            mp.pause();
        }
    }

    //activa el modo bucle de la cancion
    public void modoCiercular(View v)
    {
        //cambiamos el texto y hacemos que haga lo contrario
        if(circular.getText().toString().compareTo("No Reproducir de Forma Circular")==0)
            circular.setText("Reproducir de Forma Circular");
        else
            circular.setText("No Reproducir de Forma Circular");

        this.iniciarAudio(v);
    }
}
