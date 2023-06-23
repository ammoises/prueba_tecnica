package com.bimbo.recompensas.service;

import java.util.List;

import com.bimbo.recompensas.model.Item;

public interface IItemService {

	void guardar(Item item);
	void eliminar(Integer idItem);
	List<Item> buscarTodos();
	Item buscarPorNombre(String item);
	Item buscarPorIdItem(Integer idItem);
}
