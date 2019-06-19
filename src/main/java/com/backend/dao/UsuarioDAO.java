package com.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.model.Usuario;
@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, String> {
	
	@Query("SELECT u FROM Usuario u WHERE u.email = :pemail")
	public Usuario findByemail(@Param("pemail") String email);
	
	public Usuario save(Usuario usuario);
	
	public void deleteByemail(String email);
}
