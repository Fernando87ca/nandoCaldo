package com.src.imagelistview;

public class Persona
{
    private String nombre;
    private char genero;

    public Persona(String pNombre, char pGenero)
    {
        this.nombre = pNombre;
        this.genero = pGenero;
    }

    // ** Gettters & Setters ** //
    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public char getGenero()
    {
        return genero;
    }

    public void setGenero(char genero)
    {
        this.genero = genero;
    }
}
