package com.backend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Usuario {

	@Id
	private String email;
	private String password;
	private String primeiroNome;
	private String ultimoNome;
	@OneToMany
	private List<Comentario> comentariosFeitos;
	@ManyToMany(mappedBy = "likes")
	private List<PerfilDisciplina> disciplinasComLikes;

	public Usuario() {
	}

	public Usuario(String primeiroNome, String ultimoNome, String email, String password) {
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.email = email;
		this.password = password;
		this.disciplinasComLikes = new ArrayList<PerfilDisciplina>();
		this.comentariosFeitos = new ArrayList<Comentario>();
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Comentario> getComentariosFeitos() {
		return this.comentariosFeitos;
	}

	public void setComentariosFeitos(List<Comentario> comentariosFeitos) {
		this.comentariosFeitos = comentariosFeitos;
	}

	public List<PerfilDisciplina> getDisciplinasComLikes() {
		return disciplinasComLikes;
	}

	public void setDisciplinasComLikes(List<PerfilDisciplina> disciplinasComLikes) {
		this.disciplinasComLikes = disciplinasComLikes;
	}
}
