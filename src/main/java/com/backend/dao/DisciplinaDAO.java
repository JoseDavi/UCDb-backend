package com.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.model.Disciplina;
import com.backend.model.Usuario;
@Repository
public interface DisciplinaDAO extends JpaRepository<Usuario, String> {
	
	@Query("SELECT d FROM Disciplina d WHERE d.nome like '%discname%'")
	public Disciplina findLikeName(@Param("discname") String nome);
}
