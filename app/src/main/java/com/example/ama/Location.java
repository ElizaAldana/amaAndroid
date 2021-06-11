package com.example.ama;

import androidx.annotation.NonNull;

public class Location {
    private String nombre, descripcion, direccion, horario, telefono;

    public Location(){

    }
    public Location(String descripcion, String direccion, String telefono, String horario, String nombre) {
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horario = horario;
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre+"\n"+descripcion+"\n"+direccion+"\n"+telefono+"\n"+"Horario: "+horario;
    }
}


