package com.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dao.DisciplinaDAO;
import com.backend.dao.UsuarioDAO;
import com.backend.model.Disciplina;
import com.backend.model.Usuario;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaDAO disciplinaDAO;

	@Autowired
	private UsuarioDAO usuarioDAO;

	public Disciplina save(Disciplina disciplina) {
		return disciplinaDAO.save(disciplina);
	}

	public Disciplina findById(long id) {
		return disciplinaDAO.findById(id);
	}

	public List<Disciplina> findLikeName(String nome) {
		return disciplinaDAO.findLikeName(nome);
	}

	public List<Disciplina> saveAll(List<Disciplina> disciplinas) {
		return this.disciplinaDAO.saveAll(disciplinas);
	}

	public List<Disciplina> findAll() {
		return this.disciplinaDAO.findAll();
	}
}
