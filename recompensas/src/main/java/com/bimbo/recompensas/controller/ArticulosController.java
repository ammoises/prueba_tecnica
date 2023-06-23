package com.bimbo.recompensas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bimbo.recompensas.model.Articulo;
import com.bimbo.recompensas.service.IArticuloService;

@Controller
@RequestMapping("/articulos")
public class ArticulosController {

	@Autowired
	private IArticuloService serviceArticulo;

	@GetMapping("/index")
	public String showIndex(Model model) {
		List<Articulo> lista = serviceArticulo.buscarTodos();
		model.addAttribute("articulos", lista);
		return "articulos/listArticulos";
	}

}
