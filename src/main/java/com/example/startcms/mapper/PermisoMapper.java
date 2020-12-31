package com.example.startcms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.startcms.model.Permiso;

public class PermisoMapper implements RowMapper<Permiso>{

	@Override
	public Permiso mapRow(ResultSet rs, int rowNum) throws SQLException {
		Permiso permiso = new Permiso();
		permiso.setId_permiso(rs.getLong("id_permiso"));
		permiso.setNombre_permiso(rs.getString("nombre_permiso"));
		return permiso;
	}

}
