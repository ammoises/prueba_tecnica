package com.bimbo.recompensas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bimbo.recompensas.model.Usuario;
import com.bimbo.recompensas.service.IUsuariosService;


@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private IUsuariosService serviceUsuarios;

	
	@GetMapping("/index")
	public String showIndex(Model model) {
		List<Usuario> lista = serviceUsuarios.buscarTodos();
		model.addAttribute("usuarios", lista);
		return "usuarios/listUsuarios";
	}

	

}
