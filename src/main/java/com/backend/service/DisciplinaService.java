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
	
	public Disciplina curtiu(long id, String email) {
		Disciplina disciplina_auxiliar = disciplinaDAO.findById(id);
		Usuario usuario_auxiliar = usuarioDAO.findByemail(email);
		
		if(disciplina_auxiliar == null) {
			throw new RuntimeException("Disciplina não existe");
		}
		
		if(usuario_auxiliar == null) {
			throw new RuntimeException("Usuario não existe");
		}
		
		if(disciplina_auxiliar.getLikes().contains(usuario_auxiliar)) {
			disciplina_auxiliar.getLikes().remove(usuario_auxiliar);
		}else {
			disciplina_auxiliar.getLikes().add(usuario_auxiliar);
		}
		return disciplinaDAO.save(disciplina_auxiliar);
		
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
