package com.bimbo.recompensas.service.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bimbo.recompensas.model.Recompensa;
import com.bimbo.recompensas.repository.RecompensasRepository;
import com.bimbo.recompensas.service.IRecompensaService;

@Service
public class RecompensaServiceJpa implements IRecompensaService{

	@Autowired
	private RecompensasRepository recompensaRepo;
	
	public void guardar(Recompensa recompensa) {
		recompensaRepo.save(recompensa);
	}

	public void eliminar(Integer idRecompensa) {
		recompensaRepo.deleteById(idRecompensa);
	}

	public List<Recompensa> buscarTodos() {
		return recompensaRepo.findAll();
	}

	/*
	public List<Recompensa> buscarPorId(Integer id) {
		
		recompensaRepo.findById(id);
		
		return 
	}
	*/
	

}
