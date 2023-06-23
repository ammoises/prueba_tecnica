package com.bimbo.recompensas.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bimbo.recompensas.model.Item;
import com.bimbo.recompensas.repository.ItemsRepository;
import com.bimbo.recompensas.service.IItemService;

@Service
public class ItemServiceJpa implements IItemService {

	@Autowired
	private ItemsRepository recompensaRepo;
	
	
	public void guardar(Item recompensa) {
		recompensaRepo.save(recompensa);
		
	}

	
	public void eliminar(Integer idRecompensa) {
		recompensaRepo.deleteById(idRecompensa);
		
	}

	
	public List<Item> buscarTodos() {
		return recompensaRepo.findAll();
	}

	
	public Item buscarPorNombre(String nombre) {
		return recompensaRepo.findByItem(nombre);
	}

	
	public Item buscarPorIdItem(Integer idItem) {
		Optional<Item> item = recompensaRepo.findById(idItem);
		if(item.isPresent()) {
			return item.get();
		}
		return null;
	}

}
