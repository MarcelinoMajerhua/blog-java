package com.example.startcms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.startcms.model.Contenido;

public class ContenidoMapper  implements RowMapper<Contenido>{

	@Override
	public Contenido mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contenido contenido = new Contenido();
		contenido.setContenido(rs.getString("contenido"));
		contenido.setId_contenido(rs.getLong("id_contenido"));
		contenido.setId_post(rs.getLong("id_post"));
		contenido.setTipo_post(rs.getString("tipo_post"));
		
		return contenido;
	}

}
