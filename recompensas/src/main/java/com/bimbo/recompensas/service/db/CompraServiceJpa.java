package com.bimbo.recompensas.service.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bimbo.recompensas.model.Compra;
import com.bimbo.recompensas.repository.CompraRepository;
import com.bimbo.recompensas.service.ICompraService;

@Service
public class CompraServiceJpa implements ICompraService{

	@Autowired
	private CompraRepository compraRepo;
	
	public void guardar(Compra compra) {
		compraRepo.save(compra);
	}

	public List<Compra> buscarTodos() {
		return compraRepo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		compraRepo.deleteById(id);
		
	}

}
