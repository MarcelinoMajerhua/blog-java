package com.example.startcms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.startcms.mapper.ComentarioMapper;
import com.example.startcms.model.Comentario;

@Repository
public class ComentarioRepository implements ComentarioRep {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Comentario object) {
		try {
			String sql = String.format("insert into comentario(comentario,"
					+ "respuesta,id_usuario,id_post"
					+ "values ('%s','%s','%d','%d'))",
					object.getComentario(),object.getRespuesta(),
					object.getId_usuario(),object.getId_post());
			jdbcTemplate.execute(sql);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Comentario object) {
		if (object.getId_comentario()>0) {
			String sql = String.format("update comentario set"
					+ " comentario='%s',respuesta='%s'"
					+ "where id_comentario='%d'", object.getComentario(),
					object.getRespuesta(),object.getId_comentario());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Comentario> findAll(Pageable pageable) {
		return jdbcTemplate.query("SELECT * FROM comentario",new ComentarioMapper());
	}

	@Override
	public Comentario findById(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM comentario where id_comentario = ? ", new ComentarioMapper(),id);
	}
}
