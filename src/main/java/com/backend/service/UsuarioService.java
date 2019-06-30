package com.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dao.UsuarioDAO;
import com.backend.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	public UsuarioService(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public Usuario save(Usuario usuario) {
		return usuarioDAO.save(usuario);
	}

	public Usuario findByemail(String email) {
		return usuarioDAO.findByemail(email);
	}

}
