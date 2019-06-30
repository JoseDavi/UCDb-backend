package com.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.model.PerfilDisciplina;

@Repository
public interface PerfilDisciplinaDAO extends JpaRepository<PerfilDisciplina, Long>{
	
	@SuppressWarnings("unchecked")
	public PerfilDisciplina save(PerfilDisciplina perfil);
	
	@Query("SELECT p FROM PerfilDisciplina p WHERE p.id = :pId")
	public PerfilDisciplina findById(@Param("pId") long id);
}
