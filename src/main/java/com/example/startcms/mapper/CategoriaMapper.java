package com.example.startcms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.startcms.model.Categoria;

public class CategoriaMapper implements RowMapper<Categoria> {

	@Override
	public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
		Categoria categoria = new Categoria();
		
		categoria.setCategoria_superior(rs.getLong("categoria_superior"));
		categoria.setDescripcion_categoria(rs.getString("descripcion_categoria"));
		categoria.setFecha_categoria(rs.getDate("fecha_categoria"));
		categoria.setNombre_cateoria(rs.getString("nombre_cateoria"));
		categoria.setId_categoria(rs.getLong("id_categoria"));
		return categoria;
	}

}
