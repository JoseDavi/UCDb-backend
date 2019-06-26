package com.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.exceptions.usuarioAlreadyExistsException;
import com.backend.exceptions.usuarioNotFoundException;
import com.backend.model.Disciplina;
import com.backend.model.Usuario;
import com.backend.service.DisciplinaService;
import com.backend.service.UsuarioService;

@RestController
@RequestMapping({"/v1/users"})
public class DisciplinaController {
	private DisciplinaService disciplinaService;
	
	public DisciplinaController (DisciplinaService disciplinaService) {
		this.disciplinaService = disciplinaService;
	}
	@PostMapping(value = "/")
	@ResponseBody
	public ResponseEntity<Iterable<Disciplina>> save(@RequestBody Iterable<Disciplina> disciplinas) {
		Iterable<Disciplina> disciplinas2 = this.disciplinaService.save(disciplinas);
		return new ResponseEntity<Iterable<Disciplina>>(disciplinas2, HttpStatus.CREATED);
	}
}
