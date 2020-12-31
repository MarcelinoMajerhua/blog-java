package com.example.startcms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.startcms.model.Comentario;

public class ComentarioMapper  implements RowMapper<Comentario>{

	@Override
	public Comentario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Comentario comentario = new Comentario();
		comentario.setComentario(rs.getString("comentario"));
		comentario.setFecha_comentario(rs.getDate("fecha_comentario"));
		comentario.setId_comentario(rs.getLong("id_comentario"));
		comentario.setId_post(rs.getLong("id_post"));
		comentario.setId_usuario(rs.getLong("id_usuario"));
		comentario.setRespuesta(rs.getLong("respuesta"));
		return comentario;
	}

}
