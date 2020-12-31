package com.example.startcms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.startcms.model.Usuario;

public class UsuarioMapper implements RowMapper<Usuario>{

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario usu = new Usuario();
		usu.setApellido_usuario(rs.getString("apellido_usuario"));
		usu.setContrasenia_usuario(rs.getString("contrasenia_usuario"));
		usu.setCorreo_usuario(rs.getString("correo_usuario"));
		usu.setId_grupo(rs.getLong("id_grupo"));
		usu.setId_usuario(rs.getLong("id_usuario"));
		usu.setNombre_usuario(rs.getString("nombre_usuario"));
		return usu;
	}

}
