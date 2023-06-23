package com.bimbo.recompensas.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import com.bimbo.recompensas.model.Perfil;
import com.bimbo.recompensas.model.Punto;
import com.bimbo.recompensas.service.IPuntoService;

import com.bimbo.recompensas.model.Usuario;
import com.bimbo.recompensas.service.IUsuariosService;

@Controller
public class HomeController {

	@Autowired
	private IUsuariosService serviceUsuarios;

	@Autowired
	private IPuntoService servicePuntos;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/login")
	public String showLogin(HttpSession session) {

		if (session.getAttribute("usuario") != null) {
			return "redirect:/";
		}

		return "formLogin";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		return "redirect:/login";
	}

	@GetMapping("/signup")
	public String showResgisterUser(Usuario usuario, Model model) {
		return "usuarios/formRegistro";
	}

	@PostMapping("/signup")
	public String saveUser(Usuario usuario, BindingResult result, Model model,  RedirectAttributes attributes) {

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("error: " + error.getDefaultMessage());
			}
			return "/usuarios/formRegistro";
		}

		Usuario xUser = serviceUsuarios.buscarPorUsername(usuario.getUsername());
		if(xUser != null) {
			model.addAttribute("msg", "Ya se encuentra registrado el usuario, intente con otro");
			return "/usuarios/formRegistro";
		}
		
		xUser = serviceUsuarios.buscarPorEmail(usuario.getEmail());
		if(xUser != null) {
			model.addAttribute("msg", "Email ya esta siendo usado por otro usuario");
			return "/usuarios/formRegistro";
		}
		
		//System.out.println(xUser);
		
		try {
			String pwdPlano = usuario.getPassword();
			String pwdEncriptado = passwordEncoder.encode(pwdPlano);
			usuario.setPassword(pwdEncriptado);

			// Activado por defecto
			usuario.setEstatus(1);
			usuario.setFechaRegistro(new Date());

			// Creamos el Perfil que le asignaremos al usuario nuevo
			// Perfil administrador
			Perfil perfil = new Perfil();
			perfil.setId(1);
			usuario.agregar(perfil);

			serviceUsuarios.guardar(usuario);

			// creamos los puntos
			Punto puntos = new Punto();
			puntos.setId(usuario.getId());
			puntos.setPuntos(0);

			servicePuntos.guardar(puntos);

			attributes.addFlashAttribute("msg", "El registro fue guardado correctamente!");
		
			
		} catch (DataAccessException ex) {
			model.addAttribute("msg", ex.getLocalizedMessage());
			return "/usuarios/formRegistro";
		}
		
		model.addAttribute("msg", "El usuario fue registrado correctamente!");
		return "redirect: /usuarios/formRegistro";
	}

	@GetMapping("/")
	public String showHome(Model model, Authentication auth, HttpSession session) {
		String username = auth.getName();

		for (GrantedAuthority rol : auth.getAuthorities()) {
			System.out.println("Rol: " + rol);
		}

		if (session.getAttribute("usuario") == null) {
			Usuario usuario = serviceUsuarios.buscarPorUsername(username);
			usuario.setPassword(null);
			session.setAttribute("usuario", usuario);

			System.out.println("El usuario se encontro");
			System.out.println(usuario);
		}

		return "home";
	}

	@GetMapping("/index")
	public String mostrarIndex(Authentication auth, HttpSession session) {
		String username = auth.getName();

		for (GrantedAuthority rol : auth.getAuthorities()) {
			System.out.println("Rol: " + rol);
		}

		if (session.getAttribute("usuario") == null) {
			Usuario usuario = serviceUsuarios.buscarPorUsername(username);
			usuario.setPassword(null);
			session.setAttribute("usuario", usuario);
			System.out.println("El usuario se encontro");
			System.out.println(usuario);
		}

		return "redirect:/";
	}

}
