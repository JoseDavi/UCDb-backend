package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.PerfilDisciplina;
import com.backend.service.PerfilDisciplinaService;

/**
 * Classe que controla as requisicoes referentes ao Perfil de Disciplina.
 * 
 * @author jd-davi
 *
 */
@RestController
@RequestMapping({ "/v1/perfilDisciplinas" })
public class PerfilDisciplinaController {

	@Autowired
	private PerfilDisciplinaService perfildisciplinaService;

	/**
	 * Chama o metodo do service de perfil de disciplina para pesquisar um perfil pelo id
	 *  
	 * @param id: id do perfil a ser pesquisado.
	 * @return: ResponseEntity<PerfilDisciplina>
	 */
	@GetMapping(value = "{id}")
	@ResponseBody
	public ResponseEntity<PerfilDisciplina> findById(@PathVariable long id) {
		return new ResponseEntity<PerfilDisciplina>(this.perfildisciplinaService.findById(id), HttpStatus.OK);
	}

	/**
	 * Chama o metodo do service de perfil de disciplina para um usuario adicionar uma curtida em um perfil de uma disciplina.
	 * 
	 * @param id: id do perfil da disciplina.
	 * @param email: email do usuario que vai curtir.
	 * @return: ResponseEntity<PerfilDisciplina>
	 */
	@PostMapping(value = "/curtiu/{id}/{email}")
	@ResponseBody
	public ResponseEntity<PerfilDisciplina> curtiu(@PathVariable long id, @PathVariable String email) {
		return new ResponseEntity<PerfilDisciplina>(this.perfildisciplinaService.curtiu(id, email), HttpStatus.OK);
	}

	/**
	 * Chama o metodo do service de perfil de disciplina para um usuario adicionar um comentario em um perfil de uma disciplina. 
	 * 
	 * @param id: id do perfil da disciplina.
	 * @param email: email do usuario que vai comentar.
	 * @param comentario: comentario do usuario.
	 * @return: ResponseEntity<PerfilDisciplina>
	 */
	@PostMapping(value = "/comentou/{id}/{email}")
	@ResponseBody
	public ResponseEntity<PerfilDisciplina> comentou(@PathVariable long id, @PathVariable String email,
			@RequestBody String comentario) {
		return new ResponseEntity<PerfilDisciplina>(this.perfildisciplinaService.comentou(id, email, comentario),
				HttpStatus.OK);
	}

	/**
	 * Chama o metodo do service de perfil de disciplina para deletar um comentario de uma disciplina.
	 * 
	 * @param id: id do comentario a ser deletado
	 * @param comentario
	 * @return: ResponseEntity<PerfilDisciplina>
	 */
	@DeleteMapping(value = "/deleteComentario/{id}")
	@ResponseBody
	public ResponseEntity<PerfilDisciplina> deleteByIdComentario(@PathVariable long id,@RequestBody String comentario) {
		return new ResponseEntity<PerfilDisciplina>(this.perfildisciplinaService.deleteByIdComentario(id),
				HttpStatus.OK);
	}
	
	/**
	 * Chama o metodo do service de perfil de disciplina para adicionar um comentario/resposta a um comentario de um perfil.
	 * 
	 * @param idDisc: id do perfil da dsiciplina.
	 * @param email: email do usuario que vai comentar/responder.
	 * @param idComentario: id do comentario que vai ser respondido;
	 * @param comentario: comentario do usuario;
	 * @return: ResponseEntity<PerfilDisciplina>
	 */
	@PostMapping(value = "/comentouById/{idDisc}/{email}/{idComentario}")
	@ResponseBody
	public ResponseEntity<PerfilDisciplina> comentouById(@PathVariable long idDisc,@PathVariable String email,@PathVariable long idComentario, @RequestBody String comentario){
		return new ResponseEntity<PerfilDisciplina>(this.perfildisciplinaService.comentouById(idDisc,idComentario,comentario,email),HttpStatus.OK);
	}
	
	/**
	 * Chama o metodo do service de perfil de disciplina que retorna a  lista de perfis ordenados pela quantidade de likes.
	 * 
	 * @return: ResponseEntity<List<PerfilDisciplina>>
	 */
	@GetMapping(value = "/getByLikes")
	@ResponseBody
	public ResponseEntity<List<PerfilDisciplina>> findAllByNumeroLikes() {
		return new ResponseEntity<List<PerfilDisciplina>>(this.perfildisciplinaService.findAllByNumeroLikes(), HttpStatus.OK);
	}
	
	/**
	 * Chama o metodo do service de perfil de disciplina que retorna a  lista de perfis ordenados pela quantidade de comentarios.
	 * 
	 * @return: ResponseEntity<List<PerfilDisciplina>>
	 */
	@GetMapping(value = "/getByComentarios")
	@ResponseBody
	public ResponseEntity<List<PerfilDisciplina>> findAllByNumeroComentarios() {
		return new ResponseEntity<List<PerfilDisciplina>>(this.perfildisciplinaService.findAllByNumeroComentarios(), HttpStatus.OK);
	}
}