package com.bimbo.recompensas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bimbo.recompensas.model.Item;
import com.bimbo.recompensas.service.IItemService;


@Controller
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private IItemService serviceItem;

	@GetMapping("/index")
	public String showIndex(Model model) {
		List<Item> lista = serviceItem.buscarTodos();
		model.addAttribute("items", lista);
		return "items/listItems";
	}
	
}
