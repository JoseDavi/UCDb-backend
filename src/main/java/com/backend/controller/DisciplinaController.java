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
import com.backend.service.DisciplinaService;


@RestController
@RequestMapping({"/v1/disciplinas"})
public class DisciplinaController {
	private DisciplinaService disciplinaService;
	
	public DisciplinaController (DisciplinaService disciplinaService) {
		this.disciplinaService = disciplinaService;
	}
	@PostMapping(value = "/")
	@ResponseBody
	public ResponseEntity<Disciplina> save(@RequestBody Disciplina disciplina) {
		Disciplina disciplina2 = this.disciplinaService.save(disciplina);
		return new ResponseEntity<Disciplina>(disciplina2, HttpStatus.CREATED);
	}
	@PostMapping(value = "/curtiu/{id}/{email}")
	@ResponseBody
	public ResponseEntity<Disciplina> curtiu(@PathVariable long id,@PathVariable String email){
		Disciplina disciplina2 = this.disciplinaService.curtiu(id, email);
		return new ResponseEntity<Disciplina>(disciplina2, HttpStatus.OK);
	}
	@GetMapping(value = "{id}")
	@ResponseBody
	public ResponseEntity<Disciplina> findById(@PathVariable long id){
		Disciplina disciplina2 = this.disciplinaService.findById(id);
		return new ResponseEntity<Disciplina>(disciplina2, HttpStatus.OK);
	}
	@GetMapping(value = "/find/{nome}")
	@ResponseBody
	public ResponseEntity<Disciplina> findLikeName(@PathVariable String nome){
		Disciplina disciplina = this.disciplinaService.findLikeName(nome);
		if (disciplina == null) {
			throw new usuarioNotFoundException("Usuario não existe!");
		}
		return new ResponseEntity<Disciplina>(disciplina,HttpStatus.OK);
		
	}
}
