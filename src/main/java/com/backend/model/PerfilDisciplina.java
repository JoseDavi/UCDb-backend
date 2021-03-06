package com.backend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * classe que sera uma tabela no banco de dados para armazenar os perfis das disciplinas.
 * 
 * @author jd-davi
 *
 */
@Entity
public class PerfilDisciplina {

	@Id
	private long id;

	@OneToOne
	private Disciplina disciplina;

	@OneToMany
	private List<Comentario> comentarios;

	@ManyToMany
	@JoinTable(name = "Likes", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "email") })
	private List<Usuario> likes;
	private int numeroComentarios;
	private int numeroLikes;
	public PerfilDisciplina() {

	}

	public int getNumeroComentarios() {
		return numeroComentarios;
	}

	public void setNumeroComentarios(int numeroComentarios) {
		this.numeroComentarios = numeroComentarios;
	}

	public int getNumeroLikes() {
		return numeroLikes;
	}

	public void setNumeroLikes(int numeroLikes) {
		this.numeroLikes = numeroLikes;
	}

	public PerfilDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
		this.id = disciplina.getId();
		this.comentarios = new ArrayList<Comentario>();
		this.likes = new ArrayList<Usuario>();
	}

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public void setLikes(List<Usuario> likes) {
		this.likes = likes;
	}

	public List<Usuario> getLikes() {
		return this.likes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
