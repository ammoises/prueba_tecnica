package com.bimbo.recompensas.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bimbo.recompensas.model.Articulo;
import com.bimbo.recompensas.repository.ArticulosRepository;
import com.bimbo.recompensas.service.IArticuloService;

@Service
public class ArticuloServiceJpa implements IArticuloService{

	@Autowired
	private ArticulosRepository articuloRepo;
	
	@Override
	public void guardar(Articulo articulo) {
		articuloRepo.save(articulo);	
	}

	@Override
	public void eliminar(Integer idArticulo) {
		articuloRepo.deleteById(idArticulo);
	}

	@Override
	public List<Articulo> buscarTodos() {
		return articuloRepo.findAll();
	}

	@Override
	public Articulo buscarPorNombre(String nombre) {
		return articuloRepo.findByNombre(nombre);
	}


	public Articulo buscarPorId(Integer idArticulo) {
		Optional<Articulo> articulo = articuloRepo.findById(idArticulo);
		if(articulo.isPresent()) {
			return articulo.get();
		}
		return null;
	}
	

}
