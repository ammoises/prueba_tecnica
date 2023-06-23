package com.bimbo.recompensas.service;

import java.util.List;
import com.bimbo.recompensas.model.Usuario;

public interface IUsuariosService {

	void guardar(Usuario usuario);
	void eliminar(Integer idUsuario);
	List<Usuario> buscarTodos();
	Usuario buscarPorUsername(String username);
	Usuario buscarPorEmail(String email);
}


