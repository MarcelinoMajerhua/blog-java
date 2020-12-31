package com.example.startcms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.startcms.model.UsuarioMetadata;

public class UsuarioMetaMapper implements RowMapper<UsuarioMetadata> {

	@Override
	public UsuarioMetadata mapRow(ResultSet rs, int rowNum) throws SQLException {
		UsuarioMetadata usum = new UsuarioMetadata();
		usum.setClave(rs.getString("clave"));
		usum.setId_usuario(rs.getLong("id_usuario"));
		usum.setId_usuario_metadata(rs.getLong("id_usuario_metadata"));
		usum.setTipo(rs.getString("tipo"));
		usum.setValor(rs.getString("valor"));
		return usum;
	}

}
