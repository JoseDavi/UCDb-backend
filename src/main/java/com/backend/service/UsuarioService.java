package com.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dao.UsuarioDAO;
import com.backend.model.Usuario;

/**
 * Classe que contem os servicos disponiveis para Usuario.
 * 
 * @author jd-davi
 *
 */
@Service
public class UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	public UsuarioService(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	/**
	 * Chama o metodo do usuarioDAO que se comunica com o bd para salvar um usuario.
	 * 
	 * @param usuario: usuario a ser salvo.
	 * @return Usuario
	 */
	public Usuario save(Usuario usuario) {
		return usuarioDAO.save(usuario);
	}

	/**
	 * Chama o metodo do usuarioDAO que se comunica com o bd para pesquisar um usuario por email.
	 * 
	 * @param email: email do usuario sendo pesquisado.
	 * @return Usuario
	 */
	public Usuario findByemail(String email) {
		return usuarioDAO.findByemail(email);
	}

}
