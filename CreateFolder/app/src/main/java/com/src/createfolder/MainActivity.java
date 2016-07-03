package com.src.createfolder;

import android.Manifest;
import android.Manifest.permission;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.canelmas.let.AskPermission;
import com.canelmas.let.DeniedPermission;
import com.canelmas.let.RuntimePermissionListener;
import com.canelmas.let.RuntimePermissionRequest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RuntimePermissionListener
{
    //private static final int REQUEST_WRITE_STORAGE = 112;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //File myCarpeta = getDir("nando",MODE_PRIVATE);
        //File otraCarpeta = new File(myCarpeta,"caldo");
        //otraCarpeta.mkdir();
        //Log.d("MYTAG",otraCarpeta.getAbsolutePath());


        //Esto no se puede hacer en la ultima version de android por tema permisos, en el mobil de rafa funciona
        //Parece que en la nueva version se le debe pedir permiso al usuario, mirar como va esto


        //File externalFilesDir = getExternalFilesDir(null);
        //String absolutePath = externalFilesDir.getAbsolutePath();

        //boolean hasPermission = (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
        //if (!hasPermission)
        //{
            //ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_WRITE_STORAGE);


            //con anotaciones mola mas
            crearCarpeta();
        //}
    }

    @AskPermission(permission.WRITE_EXTERNAL_STORAGE)
    private void crearCarpeta()
    {
        File externalStorageDirectory =  Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        Log.d("mytag","Exists: " + externalStorageDirectory.exists());
        File nandoCaldo = new File(externalStorageDirectory,"nando-caldo2");
        if(!nandoCaldo.exists())
        {
            nandoCaldo.mkdir();
            File file = new File(nandoCaldo, "adeu.txt");
            try
            {
                file.createNewFile();
                FileWriter writer = new FileWriter(file);
                writer.write("Hola nando, te veo muy contento hoy!\n o no!");
                writer.flush();
                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onShowPermissionRationale(List<String> permissionList, RuntimePermissionRequest permissionRequest)
    {}

    @Override
    public void onPermissionDenied(List<DeniedPermission> deniedPermissionList)
    {}

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


}
