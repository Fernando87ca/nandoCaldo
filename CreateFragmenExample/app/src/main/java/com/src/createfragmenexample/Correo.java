package com.src.createfragmenexample;

/**
 * Created by Fernando87ca on 13/06/2016.
 */
public class Correo
{
    private String de;
    private String asunto;
    private String texto;

    public Correo(String de, String asunto, String texto){
        this.de = de;
        this.asunto = asunto;
        this.texto = texto;
    }

    public String getDe(){
        return de;
    }

    public String getAsunto(){
        return asunto;
    }

    public String getTexto(){
        return texto;
    }

    public void setDe(String de)
    {
        this.de = de;
    }

    public void setAsunto(String asunto)
    {
        this.asunto = asunto;
    }

    public void setTexto(String texto)
    {
        this.texto = texto;
    }
}
