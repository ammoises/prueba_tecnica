package com.bimbo.recompensas.service;

import java.util.List;

import com.bimbo.recompensas.model.Recompensa;

public interface IRecompensaService {

	void guardar(Recompensa recompensa);
	void eliminar(Integer idRecompensa);
	List<Recompensa> buscarTodos();
	//List<Recompensa> buscarPorId(Integer id);
	
}
