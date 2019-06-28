package com.backend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Comentario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String comentario;
	private Usuario usuario;
	private List<Resposta> respostas;
	public Comentario() {
		
	}
	public Comentario(String comentario,Usuario usuario) {
		this.comentario = comentario;
		this.usuario = usuario;
		this.respostas = new ArrayList<Resposta>();
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
	public List<Resposta> getRespostas(){
		return this.respostas;
	}
	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
}
