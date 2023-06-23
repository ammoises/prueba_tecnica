package com.bimbo.recompensas.service;

import java.util.List;

import com.bimbo.recompensas.model.Compra;

public interface ICompraService {

	void guardar(Compra compra);
	void eliminar(Integer id);
	List<Compra> buscarTodos();
	
}
