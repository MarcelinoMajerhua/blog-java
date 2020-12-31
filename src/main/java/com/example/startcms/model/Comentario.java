package com.example.startcms.model;

import java.util.Date;

public class Comentario {
    private long id_comentario;
    private String comentario;
    private Date  fecha_comentario;
    private long respuesta;
    private long id_usuario;
    private long id_post;

    public long getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(long id_comentario) {
        this.id_comentario = id_comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha_comentario() {
        return fecha_comentario;
    }

    public void setFecha_comentario(Date fecha_comentario) {
        this.fecha_comentario = fecha_comentario;
    }

    public long getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(long respuesta) {
        this.respuesta = respuesta;
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public long getId_post() {
        return id_post;
    }

    public void setId_post(long id_post) {
        this.id_post = id_post;
    }

    
}
