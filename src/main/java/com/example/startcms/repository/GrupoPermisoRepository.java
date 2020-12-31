package com.example.startcms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.startcms.mapper.GrupoPermisoMapper;
import com.example.startcms.model.GrupoPermiso;

@Repository
public class GrupoPermisoRepository implements GrupoPermisoRep {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(GrupoPermiso object) {
		try {
			String sql = String.format(
					"insert into grupo_permiso (id_grupo,id_permiso)"
					+ "values ('%d','%d')",
					object.getId_grupo(),object.getId_permiso());
			jdbcTemplate.execute(sql);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(GrupoPermiso object) {
		if (object.getId_grupo()>0) {
			String sql = String.format("update grupo_permiso set id_grupo='%d',"
					+ "id_permiso='%d',"
					+ "where id_grupo='%d'",
					object.getId_grupo(),object.getId_permiso(),object.getId_grupo());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<GrupoPermiso> findAll(Pageable pageable) {
		return jdbcTemplate.query("SELECT * FROM grupo_permiso", new GrupoPermisoMapper());
	}

	@Override
	public GrupoPermiso findById(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM grupo_permiso where id_grupo=?", new GrupoPermisoMapper(),id);
	}
}
