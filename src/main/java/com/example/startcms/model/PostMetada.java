package com.example.startcms.model;

public class PostMetada {
    private long id_post_metadata;
    private String clave;
    private String valor;
    private String tipo;
    private long id_post;

    public long getId_post_metadata() {
        return id_post_metadata;
    }

    public void setId_post_metadata(long id_post_metadata) {
        this.id_post_metadata = id_post_metadata;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getId_post() {
        return id_post;
    }

    public void setId_post(long id_post) {
        this.id_post = id_post;
    }

    
}
