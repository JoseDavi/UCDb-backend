package com.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.PerfilDisciplina;

@Repository
public interface PerfilDisciplinaDAO extends JpaRepository<PerfilDisciplina, Long>{
	
	@SuppressWarnings("unchecked")
	public PerfilDisciplina save(PerfilDisciplina perfil);
	
	public PerfilDisciplina findById(long id);
}
