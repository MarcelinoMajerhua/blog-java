package com.example.startcms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.startcms.mapper.UsuarioMapper;
import com.example.startcms.model.Usuario;

@Repository
public class UsuarioRepository implements UsuarioRep {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Usuario object) {
		try {
			String sql = String.format(
					"insert into usuario(nombre_usuario,apellido_usuario,"
					+ "contrasenia_usuario,correo_usuario,id_grupo) "
					+ "values ('%s','%s','%s','%s','%d')",
					object.getNombre_usuario(),object.getApellido_usuario(),
					object.getContrasenia_usuario(),object.getCorreo_usuario(),
					object.getId_grupo());
			jdbcTemplate.execute(sql);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Usuario object) {
		if (object.getId_usuario()>0) {
			String sql = String.format(
					"update usuario set nombre_usuario='%s',"
					+ "apellido_usuario='%s',"
					+ "contrasenia_usuario='%s',"
					+ "correo_usuario='%s',"
					+ "id_grupo='%d' where id_usuario='%d' ",
					object.getNombre_usuario(),object.getApellido_usuario(),
					object.getContrasenia_usuario(),object.getCorreo_usuario(),
					object.getId_grupo(),object.getId_usuario());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Usuario> findAll(Pageable pageable) {
		return jdbcTemplate.query("SELECT * FROM usuario",new UsuarioMapper());
	}

	@Override
	public Usuario findById(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM usuario where id_usuario=?", new UsuarioMapper(),id);
	}
}
