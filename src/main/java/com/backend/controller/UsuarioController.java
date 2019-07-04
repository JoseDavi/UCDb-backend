package com.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.exceptions.usuarioAlreadyExistsException;
import com.backend.exceptions.usuarioNotFoundException;
import com.backend.model.Usuario;
import com.backend.service.UsuarioService;

/**
 * Classe que controla as requisicoes referentes a Usuario.
 * 
 * @author jd-davi
 *
 */
@RestController
@RequestMapping({ "/v1/users" })
public class UsuarioController {

	private UsuarioService usuarioService;
	
	@Autowired
	private EmailController emailController;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	/**
	 * Chama o metodo do service de usuario para pesquisar pelo email.
	 * 
	 * @param email: email do usuario.
	 * @return: ResponseEntity<Usuario>
	 */
	@GetMapping(value = "/{email}")
	@ResponseBody
	public ResponseEntity<Usuario> findByemail(@PathVariable String email) {
		Usuario usuario = this.usuarioService.findByemail(email);

		if (usuario == null) {
			throw new usuarioNotFoundException("Usuario não existe!");
		}

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	/**
	 * Chama o metodo do service de usuario para salvar um usuario e chamar o controller de email para enviar o email de confimacao.
	 * 
	 * @param usuario: usuario.json
	 * @return: ResponseEntity<Usuario>
	 */
	@PostMapping(value = "/")
	@ResponseBody
	public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
		Usuario check = this.usuarioService.findByemail(usuario.getEmail());
		if (check != null) {
			throw new usuarioAlreadyExistsException("Usuario já existe!");
		}
		Usuario newUsuario = this.usuarioService.save(usuario);

		if (newUsuario == null) {
			throw new InternalError("Something went wrong");
		}
		this.emailController.sendMail(usuario.getEmail());

		return new ResponseEntity<Usuario>(newUsuario, HttpStatus.CREATED);
	}

}
