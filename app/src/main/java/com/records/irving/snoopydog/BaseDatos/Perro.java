package com.records.irving.snoopydog.BaseDatos;

import com.orm.SugarRecord;

/**
 * Created by I on 14/01/2016.
 */
public class Perro extends SugarRecord {

    private String Raza;
    private String Nombre;
    private String Edad;
    private String numero;
    private String Ruta;

    public Perro() {
    }

    public Perro(String raza, String nombre, String edad, String numero, String ruta) {
        Raza = raza;
        Nombre = nombre;
        Edad = edad;
        this.numero = numero;
        Ruta = ruta;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String raza) {
        Raza = raza;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRuta() {
        return Ruta;
    }

    public void setRuta(String ruta) {
        Ruta = ruta;
    }

    @Override
    public String toString() {
        return "PERROS EN ADOPCION:"+"\n"+
                "Nombre: " + Nombre +"\n"+
                "Raza: "+Raza+"\n"+
                "Edad: "+Edad+"\n"+
                "Numero: "+numero+"\n"+
                "Ruta: "+Ruta;
    }
}
