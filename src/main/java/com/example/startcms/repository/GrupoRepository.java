package com.example.startcms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.startcms.mapper.GrupoMapper;
import com.example.startcms.model.Grupo;

@Repository
public class GrupoRepository implements GrupoRep {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Grupo object) {
		try {
			String sql = String.format(
					"insert into grupo (nombre_grupo)"
					+ "values ('%s')"
					, object.getNombre_grupo());
			jdbcTemplate.execute(sql);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Grupo object) {
		if (object.getId_grupo()>0) {
			String sql = String.format(
					"update grupo set nombre_grupo='%s'"
					+ "where id_grupo='%d'",
					object.getNombre_grupo(),object.getId_grupo());
			jdbcTemplate.execute(sql);
		}
		return false;
	}

	@Override
	public List<Grupo> findAll(Pageable pageable) {
		return jdbcTemplate.query("SELECT * FROM grupo",new GrupoMapper());
	}

	@Override
	public Grupo findById(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM grupo where id_grupo=?", new GrupoMapper(),id);
	}
}
