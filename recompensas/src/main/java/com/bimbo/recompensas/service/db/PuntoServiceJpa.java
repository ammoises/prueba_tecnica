package com.bimbo.recompensas.service.db;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bimbo.recompensas.model.Punto;
import com.bimbo.recompensas.repository.PuntosRepository;
import com.bimbo.recompensas.service.IPuntoService;

@Service
public class PuntoServiceJpa implements IPuntoService {

	@Autowired
	private PuntosRepository puntosRepo;
	
	public void guardar(Punto punto) {
		puntosRepo.save(punto);
	}

	public void eliminar(Integer id) {
		puntosRepo.deleteById(id);
		
	}

	@Override
	public Punto buscarPorId(Integer id) {
		Optional<Punto> puntos = puntosRepo.findById(id);
		if(puntos.isPresent()) {
			return puntos.get();
		}
		
		return null;
	}
}
