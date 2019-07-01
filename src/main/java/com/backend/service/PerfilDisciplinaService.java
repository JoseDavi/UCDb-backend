package com.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dao.DisciplinaDAO;
import com.backend.dao.PerfilDisciplinaDAO;
import com.backend.dao.UsuarioDAO;
import com.backend.model.Comentario;
import com.backend.model.Disciplina;
import com.backend.model.PerfilDisciplina;
import com.backend.model.Usuario;

@Service
public class PerfilDisciplinaService {

	@Autowired
	private PerfilDisciplinaDAO perfilDisciplinaDAO;
	@Autowired
	private DisciplinaDAO disciplinaDAO;
	@Autowired
	private UsuarioDAO usuarioDAO;

	public PerfilDisciplina save(PerfilDisciplina perfil) {
		return perfilDisciplinaDAO.save(perfil);
	}

	public PerfilDisciplina findById(long id) {
		return perfilDisciplinaDAO.findById(id);
	}

	public PerfilDisciplina curtiu(long id, String email) {
		Disciplina disciplina_auxiliar = disciplinaDAO.findById(id);
		Usuario usuario_auxiliar = usuarioDAO.findByemail(email);
		PerfilDisciplina perfilDisciplina_auxiliar = perfilDisciplinaDAO.findById(id);

		if (disciplina_auxiliar == null) {
			throw new RuntimeException("Disciplina não existe");
		}

		if (usuario_auxiliar == null) {
			throw new RuntimeException("Usuario não existe");
		}

		if (perfilDisciplina_auxiliar.getLikes().contains(usuario_auxiliar)) {
			perfilDisciplina_auxiliar.getLikes().remove(usuario_auxiliar);
		} else {
			perfilDisciplina_auxiliar.getLikes().add(usuario_auxiliar);
		}
		return perfilDisciplinaDAO.save(perfilDisciplina_auxiliar);
	}

	public PerfilDisciplina comentou(long id, String email, String comentario) {
		Disciplina disciplina_auxiliar = disciplinaDAO.findById(id);
		Usuario usuario_auxiliar = usuarioDAO.findByemail(email);
		PerfilDisciplina perfilDisciplina_auxiliar = perfilDisciplinaDAO.findById(id);
		
		if (disciplina_auxiliar == null) {
			throw new RuntimeException("Disciplina não existe");
		}

		if (usuario_auxiliar == null) {
			throw new RuntimeException("Usuario não existe");
		}
		perfilDisciplina_auxiliar.getComentarios().add(new Comentario(comentario,usuario_auxiliar));
		
		return perfilDisciplinaDAO.save(perfilDisciplina_auxiliar);
	}
}
