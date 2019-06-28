package com.backend.dao;

import org.springframework.stereotype.Repository;

import com.backend.model.PerfilDisciplina;
@Repository
public interface PerfilDisciplinaDAO {
	@SuppressWarnings("unchecked")
	public PerfilDisciplina save(PerfilDisciplina perfil);
	
	public PerfilDisciplina findById(long id);
}
