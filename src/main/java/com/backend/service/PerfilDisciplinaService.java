package com.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.backend.dao.PerfilDisciplinaDAO;
import com.backend.model.PerfilDisciplina;

public class PerfilDisciplinaService {
	@Autowired
	private PerfilDisciplinaDAO perfilDisciplinaDAO;
	public PerfilDisciplina save(PerfilDisciplina perfil) {
		return perfilDisciplinaDAO.save(perfil);
	}
	
	public PerfilDisciplina findById(long id) {
		return perfilDisciplinaDAO.findById(id);
	}
}