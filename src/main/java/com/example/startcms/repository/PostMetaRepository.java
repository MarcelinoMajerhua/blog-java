package com.example.startcms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.startcms.mapper.PostMetaMapper;
import com.example.startcms.model.PostMetada;

@Repository
public class PostMetaRepository implements PostMetaRep{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(PostMetada object) {
		try {
			String sql = String.format(
					"insert into post_metadata(clave,valor,tipo,id_post) "
					+ "values ('%s','%s','%s','%d')",
					object.getClave(),object.getValor(),object.getTipo(),object.getId_post());
			jdbcTemplate.execute(sql);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(PostMetada object) {
		if (object.getId_post_metadata()>0) {
			String sql = String.format(
					"update post_metadata set "
					+ "clave = '%s',valor='%s',tipo='%s',"
					+ "id_post_metadata='%d'",
					object.getClave(),object.getValor(),object.getTipo(),
					object.getId_post_metadata());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<PostMetada> findAll(Pageable pageable) {
		return jdbcTemplate.query("SELECT * FROM post_metadata", new PostMetaMapper());
	}

	@Override
	public PostMetada findById(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM post_metadata where id_post_metadata=?", new PostMetaMapper(),id);
	}
}
