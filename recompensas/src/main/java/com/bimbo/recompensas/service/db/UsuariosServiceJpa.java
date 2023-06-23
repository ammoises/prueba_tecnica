package com.bimbo.recompensas.service.db;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bimbo.recompensas.model.Usuario;
import com.bimbo.recompensas.repository.UsuariosRepository;
import com.bimbo.recompensas.service.IUsuariosService;

@Service
public class UsuariosServiceJpa implements IUsuariosService {

	@Autowired
	private UsuariosRepository usuariosRepo;
	
	public void guardar(Usuario usuario) {
		usuariosRepo.save(usuario);
	}

	public void eliminar(Integer idUsuario) {
		usuariosRepo.deleteById(idUsuario);
	}

	public List<Usuario> buscarTodos() {
		return usuariosRepo.findAll();
	}

	@Override
	public Usuario buscarPorUsername(String username) {
		return usuariosRepo.findByUsername(username);
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		return usuariosRepo.findByEmail(email);
	}

}
