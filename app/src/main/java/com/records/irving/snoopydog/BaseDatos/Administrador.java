package com.records.irving.snoopydog.BaseDatos;

import com.orm.SugarRecord;

/**
 * Created by I on 14/01/2016.
 */
public class Administrador extends SugarRecord {

    private String Usuario;
    private String Correo;
    private String Contraseña;
    private int Edad;
    private int Cedula;


    public Administrador() {
    }

    public Administrador(int cedula, int edad, String contraseña, String correo, String usuario) {
        setCedula(cedula);
        Edad = edad;
        Contraseña = contraseña;
        Correo = correo;
        Usuario = usuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }


    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int cedula) {
        Cedula = cedula;
    }
}
