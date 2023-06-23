package com.bimbo.recompensas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bimbo.recompensas.model.Articulo;

public interface ArticulosRepository  extends JpaRepository<Articulo, Integer>{
	
	Articulo findByNombre(String nombre);
	
}
