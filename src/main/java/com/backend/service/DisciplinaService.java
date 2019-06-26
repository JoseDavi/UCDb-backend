package com.backend.service;

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
	private UsuarioDAO usuarioDAO;

	public Disciplina save(Disciplina disciplina) {
		return disciplinaDAO.save(disciplina);
	}
	public Disciplina findById(long id) {
		return disciplinaDAO.findById(id);
	}
	public Disciplina curtiu(long id, String email) {
		Disciplina disciplina_auxiliar = disciplinaDAO.findById(id);
		Usuario usuario_auxiliar = usuarioDAO.findByemail(email);
		if(disciplina_auxiliar.getLikes().contains(usuario_auxiliar)) {
			disciplina_auxiliar.getLikes().remove(usuario_auxiliar);
		}else {
			disciplina_auxiliar.getLikes().add(usuario_auxiliar);
		}
		return disciplinaDAO.save(disciplina_auxiliar);
		
	}
	public Disciplina findLikeName(String nome) {
		return disciplinaDAO.findLikeName(nome);
	}

}
