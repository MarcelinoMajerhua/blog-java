package com.example.startcms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.startcms.model.Grupo;

public class GrupoMapper implements RowMapper<Grupo>{

	@Override
	public Grupo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Grupo grupo = new Grupo();
		grupo.setNombre_grupo(rs.getString("nombre_grupo"));
		grupo.setId_grupo(rs.getLong("id_grupo"));
		return grupo;
	}
	
}
