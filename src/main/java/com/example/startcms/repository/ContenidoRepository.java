package com.example.startcms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.startcms.mapper.ContenidoMapper;
import com.example.startcms.model.Contenido;

@Repository
public class ContenidoRepository implements ContenidoRep {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Contenido object) {
		try {
			String sql = String.format("insert into contenido("
					+ "tipo_post,contenido,id_post) values ('%s','%s','%d')",
					object.getTipo_post(),object.getContenido(),object.getId_post());
			jdbcTemplate.execute(sql);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Contenido object) {
		if (object.getId_contenido()>0) {
			String sql = String.format("update contenido set tipo_post='%s,"
					+ "contenido='%s' "
					+ "where id_contenido ='%d''", object.getTipo_post(),
					object.getContenido(),
					object.getId_contenido());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Contenido> findAll(Pageable pageable) {
		return jdbcTemplate.query("SELECT * FROM contenido", new ContenidoMapper());
	}

	@Override
	public Contenido findById(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM contenido where id_contenido=? ", new ContenidoMapper(),id);
	}
}
