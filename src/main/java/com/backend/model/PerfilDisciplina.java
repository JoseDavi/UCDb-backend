package com.backend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class PerfilDisciplina {
	
	@Id
	private long id;
	
	@OneToOne
	private Disciplina disciplina;
	
	@OneToMany
	private List<Comentario> comentarios;

	public PerfilDisciplina() {

	}

	public PerfilDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
		this.id = disciplina.getId();
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
