package com.example.startcms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.startcms.mapper.UsuarioMetaMapper;
import com.example.startcms.model.UsuarioMetadata;

@Repository
public class UsuarioMetaRepository implements UsuarioMetaRep {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(UsuarioMetadata object) {
		try {
			String sql = String.format(
					"insert into usuario_metadata(id_usuario,"
					+ "clave,valor,tipo) values"
					+ "('%d','%s','%s,'%s'')",
					object.getId_usuario(),object.getClave(),
					object.getValor(),object.getTipo());
			jdbcTemplate.execute(sql);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean update(UsuarioMetadata object) {
		if (object.getId_usuario_metadata()>0) {
			String sql = String.format(
					"update usuario_metadata set id_usuario='%d',"
					+ "clave='%s',valor='%s',"
					+ "tipo='%s where id_usuario_metadata = '%d''",
					object.getId_usuario(),object.getClave(),
					object.getValor(),object.getTipo(),
					object.getId_usuario_metadata());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<UsuarioMetadata> findAll(Pageable pageable) {
		return jdbcTemplate.query("SELECT * FROM usuario_metadata", new UsuarioMetaMapper());
	}

	@Override
	public UsuarioMetadata findById(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM usuario_metadata where id_usuario_metadata=? ", new UsuarioMetaMapper(),id);
	}
}
