package com.example.startcms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.startcms.model.GrupoPermiso;

public class GrupoPermisoMapper implements RowMapper<GrupoPermiso> {

	@Override
	public GrupoPermiso mapRow(ResultSet rs, int rowNum) throws SQLException {
		GrupoPermiso grupop = new GrupoPermiso();
		grupop.setId_grupo(rs.getLong("id_grupo"));
		grupop.setId_permiso(rs.getLong("id_permiso"));
		return grupop;
	}

}
