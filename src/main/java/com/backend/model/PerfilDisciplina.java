package com.backend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

public class PerfilDisciplina {

	@Id
	private Disciplina disciplina;
	private List<Comentario> comentarios;

	public PerfilDisciplina() {

	}

	public PerfilDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
		this.comentarios = new ArrayList<Comentario>();
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
}
