package com.records.irving.snoopydog.BaseDatos;

import com.orm.SugarRecord;

/**
 * Created by I on 14/01/2016.
 */
public class Usuario extends SugarRecord{

    public String Usuario;
    public String Correo;
    public String Contraseña;
    public int Edad;
    public int Cedula;

    public Usuario() {

    }

    public Usuario(int cedula, int edad, String contraseña, String correo, String usuario) {
        Cedula = cedula;
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
}
