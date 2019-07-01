package com.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Disciplina;
import com.backend.model.PerfilDisciplina;
import com.backend.service.PerfilDisciplinaService;

@RestController
@RequestMapping({ "/v1/perfilDisciplinas" })
public class PerfilDisciplinaController {
	
	@Autowired
	private PerfilDisciplinaService perfildisciplinaService;
	
	@GetMapping(value = "{id}")
	@ResponseBody
	public ResponseEntity<PerfilDisciplina> findById(@PathVariable long id) {
		return new ResponseEntity<PerfilDisciplina>(this.perfildisciplinaService.findById(id), HttpStatus.OK);
	}

	@PostMapping(value = "/curtiu/{id}/{email}")
	@ResponseBody
	public ResponseEntity<PerfilDisciplina> curtiu(@PathVariable long id, @PathVariable String email) {
		return new ResponseEntity<PerfilDisciplina>(this.perfildisciplinaService.curtiu(id, email), HttpStatus.OK);
	}
	@PostMapping(value = "/comentou/{id}/{email}/{comentario}")
	@ResponseBody
	public ResponseEntity<PerfilDisciplina> comentou(@PathVariable long id, @PathVariable String email,@PathVariable String comentario){
		return new ResponseEntity<PerfilDisciplina>(this.perfildisciplinaService.comentou(id,email,comentario), HttpStatus.OK);
	}
	
}