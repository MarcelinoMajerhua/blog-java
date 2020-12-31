package com.example.startcms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.startcms.model.Post;

public class PostMapper implements RowMapper<Post> {

	@Override
	public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
		Post post = new Post();
		post.setExtracto(rs.getString("extracto"));
		post.setId_categoria(rs.getLong("id_categoria"));
		post.setId_post(rs.getLong("id_post"));
		post.setId_usuario(rs.getLong("id_usuario"));
		post.setImagen_destacada(rs.getString("imagen_destacada"));
		post.setSlug_post(rs.getString("slug_post"));
		post.setTipo_post(rs.getString("tipo_post"));
		post.setTitulo_post(rs.getString("titulo_post"));
		return post;
	}

}
