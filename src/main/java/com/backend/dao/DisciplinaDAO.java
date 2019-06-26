package com.backend.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.model.Disciplina;
@Repository
public interface DisciplinaDAO<T ,ID extends Serializable> extends JpaRepository<Disciplina, Long> {
	@Query("SELECT d FROM Disciplina d WHERE d.nome LIKE CONCAT('%', :discname, '%')")
	public Disciplina findLikeName(@Param("discname") String nome);
	
	
	public Disciplina save(Disciplina disciplina);
	
	public Disciplina findById(long id);
}
