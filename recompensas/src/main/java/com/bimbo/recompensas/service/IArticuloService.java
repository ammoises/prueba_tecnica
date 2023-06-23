package com.bimbo.recompensas.service;

import java.util.List;

import com.bimbo.recompensas.model.Articulo;

public interface IArticuloService {

	void guardar(Articulo articulo);
	void eliminar(Integer idArticulo);
	List<Articulo> buscarTodos();
	Articulo buscarPorNombre(String nombre);
	Articulo buscarPorId(Integer idArticulo);
	
}
