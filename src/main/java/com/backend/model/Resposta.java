package com.backend.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Resposta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String comentario;
	private Usuario usuario;
	public Resposta() {
		
	}
	public Resposta(String comentario,Usuario usuario) {
		this.usuario = usuario;
		this.comentario = comentario;
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
}
