package com.backend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JsonBackReference
	private PerfilDisciplina perfilDisciplina;

	private String comentario;
	@ManyToOne
	private Usuario usuario;
	private Date data_hr;
	@OneToMany
	private List<Comentario> respostas;

	public Comentario() {

	}

	public Comentario(PerfilDisciplina perfilDisciplina, String comentario, Usuario usuario) {
		this.comentario = comentario;
		this.usuario = usuario;
		this.data_hr = new Date();
		this.respostas = new ArrayList<Comentario>();
	}

	public Date getData_hr() {
		return data_hr;
	}

	public void setData_hr(Date data_hr) {
		this.data_hr = data_hr;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Comentario> getRespostas() {
		return this.respostas;
	}

	public void setRespostas(List<Comentario> respostas) {
		this.respostas = respostas;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PerfilDisciplina getPerfilDisciplina() {
		return perfilDisciplina;
	}

	public void setPerfilDisciplina(PerfilDisciplina perfilDisciplina) {
		this.perfilDisciplina = perfilDisciplina;
	}
}
