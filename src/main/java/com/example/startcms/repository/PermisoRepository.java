package com.example.startcms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.startcms.mapper.PermisoMapper;
import com.example.startcms.model.Permiso;

@Repository
public class PermisoRepository  implements PermisoRep{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Permiso object) {
		try {
			String sql = String.format(
					"insert into permiso(nombre_permiso) "
					+ "values ('%s')",
					object.getNombre_permiso());
			jdbcTemplate.execute(sql);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Permiso object) {
		if (object.getId_permiso()>0) {
			String sql = String.format(
					"update permiso set"
					+ "nombre_permiso='%s' where id_permiso='%d'",
					object.getNombre_permiso(), object.getId_permiso());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Permiso> findAll(Pageable pageable) {
		return jdbcTemplate.query("SELECT * FROM permiso", new PermisoMapper());
	}

	@Override
	public Permiso findById(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM permiso where id_permiso=?", new PermisoMapper(),id);
	}
}
