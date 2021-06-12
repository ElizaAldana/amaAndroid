package com.example.ama;

public class Consejos {
    private String nombre, consejos, id, titulo;

    public Consejos(){

    }

    public Consejos(String nombre, String consejos, String id, String titulo) {
        this.nombre = nombre;
        this.consejos = consejos;
        this.id = id;
        this.titulo =  titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConsejos() {
        return consejos;
    }

    public void setConsejos(String consejos) {
        this.consejos = consejos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
