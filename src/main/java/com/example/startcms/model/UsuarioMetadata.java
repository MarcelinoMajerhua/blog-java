package com.example.startcms.model;

public class UsuarioMetadata {
    private long id_usuario_metadata;
    private long id_usuario;
    private String clave;
    private String valor;
    private String tipo;

    public long getId_usuario_metadata() {
        return id_usuario_metadata;
    }

    public void setId_usuario_metadata(long id_usuario_metadata) {
        this.id_usuario_metadata = id_usuario_metadata;
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
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

    
}
