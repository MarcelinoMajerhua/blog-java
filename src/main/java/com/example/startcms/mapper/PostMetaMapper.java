package com.example.startcms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.startcms.model.PostMetada;

public class PostMetaMapper implements RowMapper<PostMetada> {

	@Override
	public PostMetada mapRow(ResultSet rs, int rowNum) throws SQLException {
		PostMetada postm = new PostMetada();
		postm.setClave(rs.getString("clave"));
		postm.setId_post(rs.getLong("id_post"));
		postm.setId_post_metadata(rs.getLong("id_post_metadata"));
		postm.setTipo(rs.getString("tipo"));
		postm.setValor(rs.getString("valor"));
		return postm;
	}

}
