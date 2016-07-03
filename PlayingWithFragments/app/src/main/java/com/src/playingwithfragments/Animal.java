package com.src.playingwithfragments;

/**
 * Created by Fernando87ca on 12/06/2016.
 */
public class Animal
{
    private int idImagen;
    private String nombre;
    private String descripcion;

    public Animal(int idImagen, String textoEncima, String textoDebajo)
    {
        this.idImagen = idImagen;
        this.nombre = textoEncima;
        this.descripcion = textoDebajo;
    }

    public int getIdImagen()
    {
        return idImagen;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setIdImagen(int idImagen)
    {
        this.idImagen = idImagen;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }
}
