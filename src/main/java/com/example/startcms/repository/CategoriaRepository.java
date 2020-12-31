package com.example.startcms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.startcms.mapper.CategoriaMapper;
import com.example.startcms.model.Categoria;

@Repository
public class CategoriaRepository implements CategoriaRep{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Categoria categoria) {
		try {
			String sql = String.format(
					"insert into categoria (nombre_cateoria,"
					+ "descripcion_categoria,categoria_superior)"
					+ "values ('%s','%s','%d')", 
					categoria.getNombre_cateoria(),categoria.getDescripcion_categoria(),
					categoria.getCategoria_superior());
			jdbcTemplate.execute(sql);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Categoria categoria) {
		if (categoria.getId_categoria()>0) {
			String sql = String.format("update categoria set nombre_cateoria='%s',"
					+ "descripcion_categoria='%s',"
					+ "categoria_superior='%d'"
					+ "where id_categoria='%d'", categoria.getNombre_cateoria(),
					categoria.getDescripcion_categoria(),
					categoria.getCategoria_superior(),
					categoria.getId_categoria());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Categoria> findAll(Pageable pageable) {
		
		return jdbcTemplate.query("SELECT * FROM categoria", new CategoriaMapper());
	}

	@Override
	public Categoria findById(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM categoria where id_categoria = ?", new CategoriaMapper(),id);
	}
}
