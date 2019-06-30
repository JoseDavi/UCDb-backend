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

@RestController
@RequestMapping({ "/v1/disciplinas" })
public class DisciplinaController {

	private DisciplinaService disciplinaService;
	private PerfilDisciplinaService perfilDisciplinaService;

	public DisciplinaController(DisciplinaService disciplinaService, PerfilDisciplinaService perfilDisciplinaService) {
		this.disciplinaService = disciplinaService;
		this.perfilDisciplinaService = perfilDisciplinaService;
	}

	@PostMapping(value = "/")
	@ResponseBody
	public ResponseEntity<Disciplina> save(@RequestBody Disciplina disciplina) {
		Disciplina disciplina2 = this.disciplinaService.save(disciplina);
		this.perfilDisciplinaService.save(new PerfilDisciplina(disciplina));
		return new ResponseEntity<Disciplina>(disciplina2, HttpStatus.CREATED);
	}

	@GetMapping(value = "{id}")
	@ResponseBody
	public ResponseEntity<Disciplina> findById(@PathVariable long id) {
		return new ResponseEntity<Disciplina>(this.disciplinaService.findById(id), HttpStatus.OK);
	}

	@GetMapping(value = "/")
	@ResponseBody
	public ResponseEntity<List<Disciplina>> findAll() {
		return new ResponseEntity<List<Disciplina>>(this.disciplinaService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/find/{nome}")
	@ResponseBody
	public ResponseEntity<List<Disciplina>> findLikeName(@PathVariable String nome) {
		List<Disciplina> disciplinas = this.disciplinaService.findLikeName(nome.toUpperCase());
		if (disciplinas == null) {
			throw new usuarioNotFoundException("Usuario não existe!");
		}
		return new ResponseEntity<List<Disciplina>>(disciplinas, HttpStatus.OK);

	}

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
