package com.example.ama;

public class Users {
    private String nombre, correo, contraseña, confirmacion, ciudad, id;

    public Users(){

    }

    public Users(String nombre, String correo, String contraseña, String confirmacion, String ciudad, String id) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.confirmacion = confirmacion;
        this.ciudad = ciudad;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
