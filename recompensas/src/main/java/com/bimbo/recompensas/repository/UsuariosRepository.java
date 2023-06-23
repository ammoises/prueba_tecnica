package com.bimbo.recompensas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bimbo.recompensas.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByUsername(String username);
	Usuario findByEmail(String email);
	
}
