package com.bimbo.recompensas.service;

import com.bimbo.recompensas.model.Punto;

public interface IPuntoService {

	void guardar(Punto puntos);
	void eliminar(Integer id);
	Punto buscarPorId(Integer id);
}
