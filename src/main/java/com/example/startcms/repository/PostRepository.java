package com.example.startcms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.startcms.mapper.PostMapper;
import com.example.startcms.model.Post;

@Repository
public class PostRepository implements PostRep{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Post object) {
		try {
			String sql = String.format(
					"insert into post(titulo_post,"
					+ "slug_post,"
					+ "id_usuario,extracto,id_categoria,"
					+ "imagen_destacada,tipo_post) values"
					+ "('%s','%s','%d','%s','%d','%s','%s')",
					object.getTitulo_post(),object.getSlug_post(),
					object.getId_usuario(),object.getExtracto(),
					object.getId_categoria(),object.getImagen_destacada(),
					object.getTipo_post());
			jdbcTemplate.execute(sql);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean update(Post object) {
		if (object.getId_post()>0) {
			String sql = String.format(
					"update post set titulo_post='%s',slug_post='%s',"
					+ "extracto='%s',id_categoria='%d',"
					+ "imagen_destacada='%s',tipo_post='%s',"
					+ "where id_post='%d'",
					object.getTitulo_post(),object.getSlug_post(),
					object.getExtracto(),object.getId_categoria(),
					object.getImagen_destacada(),object.getTipo_post(),
					object.getId_post());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Post> findAll(Pageable pageable) {
		return jdbcTemplate.query("SELECT * FROM post", new PostMapper());
	}

	@Override
	public Post findById(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM post where id_post=?", new PostMapper(),id);
	}
}
