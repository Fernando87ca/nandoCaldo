package com.src.productos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Operaciones
{
    private int id;
    private String descripcion;
    private float precio;

    public Operaciones()
    {}

    public String addProduct(Context pActividad,int pId, String pDescripcion,float pPrecio)
    {
        /* Llamamos a la clase que deriba de SQLiteOpenHelper para conectar contra la bdd
            *   Primer parametro: Actividad de donde proviene la llamada
            *   Segundo parametro: Nombre de la base de datos que queremos crear
            *   Tercer parametro: Cursor en la base de datos, supongo que alomejor sirve para moverse entre BDDs
            *   Cuarto parametro: version de la base de datos que estamos accediendo
            * */
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(pActividad, "administracion", null, 1);

        // con el objeto de la clase creado habrimos la conexion
        SQLiteDatabase db = admin.getWritableDatabase();
        try
        {
            // Comprobamos si el id ya existe
            Cursor filas = db.rawQuery("Select codigo from Articulos where codigo = " + pId, null);
            if(filas.getCount()<=0)
            {
                //ingresamos los valores mediante, key-value asocioados a nuestra base de datos (tecnica muñeca rusa admin <- db <- registro)
                ContentValues registro = new ContentValues();
                registro.put("codigo",pId);
                registro.put("descripcion",pDescripcion);
                registro.put("precio", pPrecio);

                //ahora insertamos este registro en la base de datos
                db.insert("Articulos", null, registro);
            }
            else
                return "El ID insertado ya existe";
        }
        catch (Exception e)
        {
            return "Error Añadiendo producto";
        }
        finally
        {
            db.close();
        }
        return "Producto Añadido Correctamente";
    }

    public void modificarProducto(Context pActividad,int pId, String pDescripcion,float pPrecio)
    {

    }

    //devolvera un map ya que solo puede haber un objeto
    public Map<String,String> selectByCode(Context pActividad,int pId)
    {
        //tenemos que devolver un mapa con los valores resultantes del Select, solo sera una row
        Map<String,String> rst = new HashMap<String,String>();

        try
        {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(pActividad, "administracion", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();

            //lanzamos una sentencia select --> el resultado de esta query vamos ha hacer que se guarde en una variable de tipo cursor
            //raw query es un metodo que hace eso precisamente, el resultado de un select a un cursor
            Cursor filas = db.rawQuery("Select descripcion, precio from Articulos where codigo = " + pId, null);
            if (filas.moveToFirst())
            {
                rst.put("descripcion", filas.getString(0));
                rst.put("precio", filas.getString(1));
            }
        }
        catch (Exception e)
        {
            Toast.makeText(pActividad,"Error al recuperar valores",Toast.LENGTH_SHORT).show();
        }
        finally
        {
            return rst;
        }
    }

    public ArrayList<ArrayList<String>> selectByDesc(Context pActividad,String pDesct)
    {
        ArrayList<ArrayList<String>> rst = new ArrayList<ArrayList<String>>();

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(pActividad, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor resultados = db.rawQuery("select codigo, descripcion, precio from Articulos where descripcion like '%"+ pDesct +"%'",null);

        if (resultados.moveToFirst())
        {
            for(int i=0; i< resultados.getCount();i++)
            {
                ArrayList<String> parcial = new ArrayList<String>();

                parcial.add(resultados.getString(0));
                parcial.add(resultados.getString(1));
                parcial.add(resultados.getString(2));

                resultados.moveToNext();
                rst.add(parcial);
            }
        }
        return rst;
    }

    public void bajaPorCodigo(Context pActividad,int pId)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(pActividad, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        //funcion delete(String table, String whereClause, String[] whereArgs)
        db.delete("Articulos","codigo="+pId,null);
        db.close();
    }
}
