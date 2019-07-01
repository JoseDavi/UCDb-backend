package com.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.model.PerfilDisciplina;

@Repository
public interface PerfilDisciplinaDAO extends JpaRepository<PerfilDisciplina, Long>{
	
	@SuppressWarnings("unchecked")
	public PerfilDisciplina save(PerfilDisciplina perfil);
	
	@Query("SELECT p FROM PerfilDisciplina p WHERE p.id = :pId")
	public PerfilDisciplina findById(@Param("pId") long id);
	
	@Query(value = "SELECT p FROM PerfilDisciplina p order by p.numeroLikes DESC, p.id ASC")
	public List<PerfilDisciplina> findAllByNumeroLikes();
	@Query(value = "SELECT p FROM PerfilDisciplina p order by p.numeroComentarios DESC, p.id ASC")
	public List<PerfilDisciplina> findAllByNumeroComentarios();
	
}
