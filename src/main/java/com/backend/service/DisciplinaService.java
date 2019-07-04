package com.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dao.DisciplinaDAO;
import com.backend.model.Disciplina;

/**
 * Classe que contem os servicos disponiveis para disciplina.
 * 
 * @author jd-davi
 *
 */
@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaDAO disciplinaDAO;
	
	/**
	 * Chama o metodo do disciplinaDAO que se comunica com o bd para salvar a disciplina.
	 * 
	 * @param disciplina: disciplina a ser salva.
	 * @return Disciplina.
	 */
	public Disciplina save(Disciplina disciplina) {
		return disciplinaDAO.save(disciplina);
	}

	/**
	 * Chama o metodo do disciplinaDAO que se comunica com o bd para buscar uma disciplina pelo id.
	 * 
	 * @param id: id da disciplina.
	 * @return Disciplina.
	 */
	public Disciplina findById(long id) {
		return disciplinaDAO.findById(id);
	}

	/**
	 * Chama o metodo do disciplinaDAO que se comunica com o bd para buscar as disciplinas que contem uma subString no nome.
	 * 
	 * @param nome: nome usado na busca
	 * @return List<Disciplina>
	 */
	public List<Disciplina> findLikeName(String nome) {
		return disciplinaDAO.findLikeName(nome);
	}

	/**
	 * Chama o metodo do disciplinaDAO que se comunica com o bd para salvar uma lista de disciplinas.
	 * 
	 * @param disciplinas: lista de disciplinas a serem salvas.
	 * @return List<Disciplina>
	 */
	public List<Disciplina> saveAll(List<Disciplina> disciplinas) {
		return this.disciplinaDAO.saveAll(disciplinas);
	}

	/**
	 * Chama o metodo do disciplinaDAO que se comunica com o bd para retornar todas as disciplinas.
	 * 
	 * @return List<Disciplina>
	 */
	public List<Disciplina> findAll() {
		return this.disciplinaDAO.findAll();
	}
}
