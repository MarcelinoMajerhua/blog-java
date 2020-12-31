package com.example.startcms.model;
import java.util.Date;

public class Categoria {
    private long id_categoria ;
    private String nombre_cateoria;
    private String descripcion_categoria;
    private Date fecha_categoria;
    private long categoria_superior;

    public long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_cateoria() {
        return nombre_cateoria;
    }

    public void setNombre_cateoria(String nombre_cateoria) {
        this.nombre_cateoria = nombre_cateoria;
    }

    public String getDescripcion_categoria() {
        return descripcion_categoria;
    }

    public void setDescripcion_categoria(String descripcion_categoria) {
        this.descripcion_categoria = descripcion_categoria;
    }

    public Date getFecha_categoria() {
        return fecha_categoria;
    }

    public void setFecha_categoria(Date fecha_categoria) {
        this.fecha_categoria = fecha_categoria;
    }

    public long getCategoria_superior() {
        return categoria_superior;
    }

    public void setCategoria_superior(long categoria_superior) {
        this.categoria_superior = categoria_superior;
    }

    
}
