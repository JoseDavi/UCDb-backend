package com.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.backend.dao.ComentarioDAO;
import com.backend.dao.DisciplinaDAO;
import com.backend.dao.PerfilDisciplinaDAO;
import com.backend.dao.UsuarioDAO;
import com.backend.model.Comentario;
import com.backend.model.Disciplina;
import com.backend.model.PerfilDisciplina;
import com.backend.model.Usuario;

/**
 * Classe que contem os servicos disponiveis para  perfil de disciplina.
 * 
 * @author jd-davi
 *
 */
@Service
public class PerfilDisciplinaService {

	@Autowired
	private PerfilDisciplinaDAO perfilDisciplinaDAO;
	@Autowired
	private DisciplinaDAO disciplinaDAO;
	@Autowired
	private UsuarioDAO usuarioDAO;
	@Autowired
	private ComentarioDAO comentarioDAO;
	
	/**
	 * Chama o metodo do perfilDisciplinaDAO que se comunica com o bd para salvar um perfil.
	 * 
	 * @param perfil: perfil a ser salvo
	 * @return PerfilDisciplina
	 */
	public PerfilDisciplina save(PerfilDisciplina perfil) {
		return perfilDisciplinaDAO.save(perfil);
	}

	/**
	 * Chama o metodo do perfilDisciplinaDAO que se comunica com o bd para pesquisar um perfil a aprtir do seu id.
	 * 
	 * @param perfil: perfil a ser salvo
	 * @return PerfilDisciplina
	 */
	public PerfilDisciplina findById(long id) {
		return perfilDisciplinaDAO.findById(id);
	}

	/**
	 * Chama o metodo do perfilDisciplinaDAO, disciplinaDAO e usuarioDAO que se comunicam com o bd para usuario adicionar/retirar uma curtida em um perfil.
	 * 
	 * @param id: id do perfil que vai receber/tirar o like
	 * @param email: email do usuario que vai dar/retirar o like
	 * @return PerfilDisciplina
	 */
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
			perfilDisciplina_auxiliar.setNumeroLikes(perfilDisciplina_auxiliar.getNumeroLikes()-1);

		} else {
			perfilDisciplina_auxiliar.getLikes().add(usuario_auxiliar);
			perfilDisciplina_auxiliar.setNumeroLikes(perfilDisciplina_auxiliar.getNumeroLikes()+1);

		}
		return perfilDisciplinaDAO.save(perfilDisciplina_auxiliar);
	}

	/**
	 *  Chama o metodo do perfilDisciplinaDAO, disciplinaDAO, usuarioDAO e comentarioDAO que se comunicam com o bd para usuario adicionar um comentario em um perfil.
	 * 
	 * @param id: id do perfil da disciplina.
	 * @param email: email do usuario.
	 * @param comentario: comentario do usuario
	 * @return PerfilDisciplina
	 */
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
		Comentario comentarioAlx = new Comentario(perfilDisciplina_auxiliar, comentario, usuario_auxiliar,null);
		Comentario newComentario = comentarioDAO.save(comentarioAlx);
		comentarioAlx.setPerfilDisciplina(perfilDisciplina_auxiliar);
		perfilDisciplina_auxiliar.getComentarios().add(newComentario);
		perfilDisciplina_auxiliar.setNumeroComentarios(perfilDisciplina_auxiliar.getNumeroComentarios()+1);
		
		return perfilDisciplinaDAO.save(perfilDisciplina_auxiliar);
	}

	/**
	 *  Chama o metodo do perfilDisciplinaDAO e comentarioDAO que se comunicam com o bd para deletar o comentario de um perfil.
	 * 
	 * @param id: do comentario a ser deletado.
	 * @return PerfilDisciplina
	 */
	public PerfilDisciplina deleteByIdComentario(long id) {
		Comentario comentario = comentarioDAO.findById(id);
		PerfilDisciplina perfilDisciplina_auxiliar = comentario.getPerfilDisciplina();
		comentario.setFoiDeletado(true);
		perfilDisciplina_auxiliar.setNumeroComentarios(perfilDisciplina_auxiliar.getNumeroComentarios()-1);

		return perfilDisciplinaDAO.save(perfilDisciplina_auxiliar);
	}

	/**
	 * Chama o metodo do perfilDisciplinaDAO, discipinaDAO, usuarioDAO e comentarioDAO que se comunicam com o bd para adicionar uma repsosta a um comentario.
	 * 
	 * @param idDisc: id do perfil.
	 * @param idComentario: id do comentario.
	 * @param comentario: comentario/resposta ao comentario.
	 * @param email: email do usario que vai comentar.
	 * @return PerfilDisciplina.
	 */
	public PerfilDisciplina comentouById(long idDisc, long idComentario, String comentario, String email) {
		Disciplina disciplina_auxiliar = disciplinaDAO.findById(idDisc);
		Usuario usuario_auxiliar = usuarioDAO.findByemail(email);
		PerfilDisciplina perfilDisciplina_auxiliar = perfilDisciplinaDAO.findById(idDisc);
		Comentario comentarioAux = comentarioDAO.findById(idComentario);
		
		if (disciplina_auxiliar == null) {
			throw new RuntimeException("Disciplina não existe");
		}

		if (usuario_auxiliar == null) {
			throw new RuntimeException("Usuario não existe");
		}
		Comentario comentarioAlx = new Comentario(perfilDisciplina_auxiliar, comentario, usuario_auxiliar,comentarioAux);
		Comentario newComentario = comentarioDAO.save(comentarioAlx);
		comentarioAlx.setPerfilDisciplina(perfilDisciplina_auxiliar);
		perfilDisciplina_auxiliar.getComentarios().add(newComentario);
		perfilDisciplina_auxiliar.setNumeroComentarios(perfilDisciplina_auxiliar.getNumeroComentarios()+1);
		return perfilDisciplinaDAO.save(perfilDisciplina_auxiliar);
	}
	
	/**
	 * Chama o metodo do perfilDisciplinaDAO que se comunica com o bd para retornar uma lista de perfis ordenados pela quantidade de likes.
	 * 
	 * @return List<PerfilDisciplina>
	 */
	public List<PerfilDisciplina> findAllByNumeroLikes(){
		return perfilDisciplinaDAO.findAllByNumeroLikes();
	}
	
	/**
	 * Chama o metodo do perfilDisciplinaDAO que se comunica com o bd para retornar uma lista de perfis ordenados pela quantidade de comentarios.
	 * 
	 * @return List<PerfilDisciplina>
	 */
	public List<PerfilDisciplina> findAllByNumeroComentarios(){
		return perfilDisciplinaDAO.findAllByNumeroComentarios();
	}
}
