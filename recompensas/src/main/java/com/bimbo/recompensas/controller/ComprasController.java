package com.bimbo.recompensas.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bimbo.recompensas.model.Articulo;
import com.bimbo.recompensas.model.Compra;
import com.bimbo.recompensas.model.Usuario;
import com.bimbo.recompensas.service.IArticuloService;
import com.bimbo.recompensas.service.ICompraService;
import com.bimbo.recompensas.service.IUsuariosService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/compras")
public class ComprasController {

	@Autowired
	private IArticuloService serviceArticulo;
	
	@Autowired
   	private IUsuariosService serviceUsuarios;
	
	@Autowired
	private ICompraService serviceCompra;

	@GetMapping("/index")
	public String showIndex(Model model) {
		List<Articulo> lista = serviceArticulo.buscarTodos();
		model.addAttribute("articulos", lista);
		return "compras/listCompra";
	}
	
	@GetMapping("/compra/{id}")
	public String compraArticulo(@PathVariable("id") int idArticulo, RedirectAttributes attributes, Authentication auth, HttpSession session) {

		Articulo articulo = serviceArticulo.buscarPorId(idArticulo);
		
		String username = auth.getName();
		Usuario user = serviceUsuarios.buscarPorUsername(username); 
		user.getPuntos().addPuntos(articulo.getPuntos());
		Integer puntos  = user.getPuntos().getPuntos();
		
		Compra compra = new Compra();
		compra.setId(user.getId());
		compra.setIdArticulo(idArticulo);
		compra.setCantidad(1);
		
		serviceUsuarios.guardar(user);
		serviceCompra.guardar(compra);
		
		attributes.addFlashAttribute("msg", "Se realizo la compra puntos acumulados totales: "+puntos);	
		
		return "redirect:/compras/index";
	}
	
	
}
