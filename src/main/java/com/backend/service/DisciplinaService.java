package com.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.backend.dao.DisciplinaDAO;
import com.backend.model.Disciplina;
import com.backend.model.Usuario;
@Service
public class DisciplinaService {
	@Autowired
	private DisciplinaDAO disciplinaDAO;

	public Iterable<Disciplina> save(Iterable<Disciplina> disciplinas) {
		return disciplinaDAO.saveAll(disciplinas);
	}

}
