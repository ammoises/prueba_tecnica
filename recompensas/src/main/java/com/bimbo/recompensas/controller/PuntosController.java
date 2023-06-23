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

import com.bimbo.recompensas.model.Item;
import com.bimbo.recompensas.model.Usuario;
import com.bimbo.recompensas.service.IItemService;
import com.bimbo.recompensas.service.IUsuariosService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/puntos")
public class PuntosController {

	@Autowired
	private IItemService serviceItems;

	@Autowired
	private IUsuariosService serviceUsuarios;

	@GetMapping("/index")
	public String showIndex(Model model, Authentication auth, HttpSession session) {
		Usuario user;

		String username = auth.getName();
		user = serviceUsuarios.buscarPorUsername(username);
		session.setAttribute("usuario", user);

		user = (Usuario) session.getAttribute("usuario");
					
		model.addAttribute("puntos", user.getPuntos().getPuntos());
		
		List<Item> lstItems = serviceItems.buscarTodos();
		model.addAttribute("items", lstItems);
		
		return "puntos/puntos";
	}

	@GetMapping("/cambiar/{idItem}")
	public String showIndex(@PathVariable("idItem") int idItem, RedirectAttributes attributes, Model model,
			Authentication auth, HttpSession session) {

		String username = auth.getName();
		Usuario user = serviceUsuarios.buscarPorUsername(username);

		Item item = serviceItems.buscarPorIdItem(idItem);
		if(!user.getPuntos().restPuntos(item.getPuntos())) {
			attributes.addFlashAttribute("msg", "No cuentas con suficientes puntos, deberas realizar otra compra para adquirir mas puntos");
			return "redirect:/puntos/index";
		}
		
		Integer puntos = user.getPuntos().getPuntos(); 
		
		serviceUsuarios.guardar(user);
		
		attributes.addFlashAttribute("msg", "Obtubiste la recompensa "+item.getItem()+", puntos restantes: "+puntos);	
		
		
		return "redirect:/puntos/index";
	}

}
