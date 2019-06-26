package com.backend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Disciplina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	@ManyToMany
	@JoinTable(name = "Likes", joinColumns = { @JoinColumn (name = "id")}, inverseJoinColumns = {@JoinColumn(name = "email")}  )
	private List<Usuario> likes;
	public Disciplina() {
	}

	public Disciplina (long id,String nome) {
		this.id = id;
		this.nome = nome;
		this.likes = new ArrayList<Usuario>();
	}

	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setLikes(List<Usuario> likes) {
		this.likes = likes;
	}
	
	public List<Usuario> getLikes() {
		return this.likes;
	}

}
