package com.salesianostriana.dam.ejemplo01;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	//Esta clase va a utilizar un servicio que va a cumplir la labor de proveer datos, pero solo porque no tenemos BD. NO HACER EN EL PROYECTO.
	
	@Autowired
	private DummyService service;
	
	
	@GetMapping({"/", "/welcome"})
	public String welcome(@RequestParam(name = "nombre", required = false, defaultValue = "Mundo")String nombre, Model model) {
		model.addAttribute("nombre", nombre);
		
		model.addAttribute("today", LocalDate.now());
		
		model.addAttribute("producto", service.getProducto());
		
		return "index";
	}
	
	@GetMapping({"/", "/welcome2"})
	public String welcome(Model model) {
		
		
		model.addAttribute("lista", service.getListaProducto());
		
		return "index2";
	}
	
	
	
}
