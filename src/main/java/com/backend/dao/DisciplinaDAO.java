package com.backend.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.model.Disciplina;
@Repository
public interface DisciplinaDAO<T ,ID extends Serializable> extends JpaRepository<Disciplina, Long> {
	
	@Query("SELECT d FROM Disciplina d WHERE d.nome LIKE %:discname%")
	public List<Disciplina> findLikeName(@Param("discname") String nome);
	
	@SuppressWarnings("unchecked")
	public Disciplina save(Disciplina disciplina);
	
	public Disciplina findById(long id);
}
