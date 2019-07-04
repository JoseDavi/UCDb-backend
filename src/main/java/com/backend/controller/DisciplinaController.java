package com.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.exceptions.usuarioNotFoundException;
import com.backend.model.Disciplina;
import com.backend.model.PerfilDisciplina;
import com.backend.service.DisciplinaService;
import com.backend.service.PerfilDisciplinaService;

/**
 * Classe que controla as requisicoes referentes a Disciplina.
 * 
 * @author jd-davi
 *
 */
@RestController
@RequestMapping({ "/v1/disciplinas" })
public class DisciplinaController {

	private DisciplinaService disciplinaService;
	private PerfilDisciplinaService perfilDisciplinaService;
	
	/**
	 * Construtor de Disciplina controller.
	 * 
	 * @param disciplinaService: Instancia do service de Disciplina.
	 * @param perfilDisciplinaService: Instancia do service de Perfil de Disciplina.
	 */
	public DisciplinaController(DisciplinaService disciplinaService, PerfilDisciplinaService perfilDisciplinaService) {
		this.disciplinaService = disciplinaService;
		this.perfilDisciplinaService = perfilDisciplinaService;
	}
	
	/**
	 * Chama o metodo do service de disciplina para salvar uma disciplina e chama o metodo do service de perfil de disciplina para salvar o perfil da disciplina salva.
	 * 
	 * @param disciplina: disciplina a ser a inserida.
	 * @return ResponseEntity<Disciplina>
	 */
	@PostMapping(value = "/")
	@ResponseBody
	public ResponseEntity<Disciplina> save(@RequestBody Disciplina disciplina) {
		Disciplina disciplina2 = this.disciplinaService.save(disciplina);
		this.perfilDisciplinaService.save(new PerfilDisciplina(disciplina));
		return new ResponseEntity<Disciplina>(disciplina2, HttpStatus.CREATED);
	}
	
	/**
	 * Chama o metodo do service de disciplina para pesquisar uma disciplina pelo id.
	 * 
	 * @param id: id da disciplina
	 * @return ResponseEntity<Disciplina>
	 */
	@GetMapping(value = "{id}")
	@ResponseBody
	public ResponseEntity<Disciplina> findById(@PathVariable long id) {
		return new ResponseEntity<Disciplina>(this.disciplinaService.findById(id), HttpStatus.OK);
	}

	/**
	 * Chama o metodo do service de disciplina para retornar todas as disciplinas.
	 * 
	 * @return: ResponseEntity<List<Disciplina>>
	 */
	@GetMapping(value = "/")
	@ResponseBody
	public ResponseEntity<List<Disciplina>> findAll() {
		return new ResponseEntity<List<Disciplina>>(this.disciplinaService.findAll(), HttpStatus.OK);
	}

	/**
	 * Chama o metodo do service de disciplina para pesquisar as disciplinas que tenha em seu nome a subString recebida.
	 * 
	 * @param nome: subString usada na pesquisa
	 * @return: ResponseEntity<List<Disciplina>>
	 */
	@GetMapping(value = "/find/{nome}")
	@ResponseBody
	public ResponseEntity<List<Disciplina>> findLikeName(@PathVariable String nome) {
		List<Disciplina> disciplinas = this.disciplinaService.findLikeName(nome.toUpperCase());
		if (disciplinas == null) {
			throw new usuarioNotFoundException("Usuario não existe!");
		}
		return new ResponseEntity<List<Disciplina>>(disciplinas, HttpStatus.OK);

	}
	
	/**
	 * Chama o metodo do service de disciplina para salvar todas disciplinas depois pega a lista de disciplinas cadastradas e salva o perfil delas uma a uma
	 * 
	 * @param disciplinas: lista de disciplinas a serem cadastradas.
	 * @return ResponseEntity<List<Disciplina>>
	 */
	@PostMapping(value = "/admin")
	@ResponseBody
	public ResponseEntity<List<Disciplina>> save(@RequestBody List<Disciplina> disciplinas) {
		List<Disciplina> disciplinascadastradas = this.disciplinaService.saveAll(disciplinas);
		for (Disciplina disciplina : disciplinascadastradas) {
			perfilDisciplinaService.save(new PerfilDisciplina(disciplina));
		}
		return new ResponseEntity<List<Disciplina>>(disciplinascadastradas, HttpStatus.CREATED);
	}
}
