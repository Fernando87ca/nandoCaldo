package com.src.ejemplointentcamara;

import android.Manifest.permission;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.canelmas.let.AskPermission;

import java.io.File;


public class MainActivity extends AppCompatActivity
{
    private ImageView foto;
    private EditText nombreFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        foto = (ImageView)findViewById(R.id.idFoto);
        nombreFoto = (EditText)findViewById(R.id.idNombreFoto);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menuopciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id==R.id.telefono)
        {
            Toast.makeText(this,R.string.telefono,Toast.LENGTH_LONG).show();
        }
        if(id==R.id.camara)
        {
            Toast.makeText(this,R.string.camara,Toast.LENGTH_LONG).show();
        }
        if (id==R.id.opcion1)
        {
            Toast.makeText(this,R.string.mensaje_1,Toast.LENGTH_LONG).show();
        }
        if (id==R.id.opcion2)
        {
            Toast.makeText(this,R.string.mensaje_2,Toast.LENGTH_LONG).show();
        }
        if (id==R.id.opcion3)
        {
            Toast.makeText(this,R.string.mensaje_3, Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @AskPermission({permission.CAMERA,
            permission.WRITE_EXTERNAL_STORAGE})
    public void tomarFoto(View v)
    {
        Intent IntentCamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File foto = new File(getExternalFilesDir(null),nombreFoto.getText().toString()+".jpg");
        IntentCamara.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(foto));
        startActivity(IntentCamara);
    }

    @AskPermission({permission.READ_EXTERNAL_STORAGE})
    public void recuperarFoto(View v)
    {
        Bitmap fotoRecuperada = BitmapFactory.decodeFile(getExternalFilesDir(null)+"/"+nombreFoto.getText().toString()+".jpg");
        foto.setImageBitmap(fotoRecuperada);
    }

    public void verFoto(View v)
    {
        Intent listadoFotosActivity = new Intent(this.getApplicationContext(),ListaResultados.class);
        startActivity(listadoFotosActivity);
    }
}
