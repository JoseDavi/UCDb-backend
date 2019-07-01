package com.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.model.Comentario;

public interface ComentarioDAO extends JpaRepository<Comentario, Long> {
	
	public Comentario findById(long id);

	public Comentario save(Comentario comentario);

}
