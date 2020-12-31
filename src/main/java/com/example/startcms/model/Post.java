package com.example.startcms.model;

public class Post {
    private long id_post;
    private String titulo_post;
    private String slug_post;
    private long id_usuario;
    private String extracto;
    private long id_categoria;
    private String imagen_destacada;
    private String tipo_post;

    public long getId_post() {
        return id_post;
    }

    public void setId_post(long id_post) {
        this.id_post = id_post;
    }

    public String getTitulo_post() {
        return titulo_post;
    }

    public void setTitulo_post(String titulo_post) {
        this.titulo_post = titulo_post;
    }

    public String getSlug_post() {
        return slug_post;
    }

    public void setSlug_post(String slug_post) {
        this.slug_post = slug_post;
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getExtracto() {
        return extracto;
    }

    public void setExtracto(String extracto) {
        this.extracto = extracto;
    }

    public long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getImagen_destacada() {
        return imagen_destacada;
    }

    public void setImagen_destacada(String imagen_destacada) {
        this.imagen_destacada = imagen_destacada;
    }

    public String getTipo_post() {
        return tipo_post;
    }

    public void setTipo_post(String tipo_post) {
        this.tipo_post = tipo_post;
    }

    
}
