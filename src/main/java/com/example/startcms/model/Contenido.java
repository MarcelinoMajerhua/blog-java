package com.example.startcms.model;

public class Contenido {
    private long id_contenido;
    private String tipo_post;
    private String contenido;
    private long id_post;

    public long getId_contenido() {
        return id_contenido;
    }

    public void setId_contenido(long id_contenido) {
        this.id_contenido = id_contenido;
    }

    public String getTipo_post() {
        return tipo_post;
    }

    public void setTipo_post(String tipo_post) {
        this.tipo_post = tipo_post;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public long getId_post() {
        return id_post;
    }

    public void setId_post(long id_post) {
        this.id_post = id_post;
    }

    
}
