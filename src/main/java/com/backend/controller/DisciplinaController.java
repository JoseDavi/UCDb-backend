package com.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
