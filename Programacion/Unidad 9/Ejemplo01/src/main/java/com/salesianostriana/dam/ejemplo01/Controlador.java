package com.salesianostriana.dam.ejemplo01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {
	
	@GetMapping({"/", "welcome"})
	public String welcome(@RequestParam(name = "nombre", required = false, defaultValue = "Mundo") String nombre, Model model) {
		model.addAttribute("nombre", nombre);
		return "index";
	}
}
