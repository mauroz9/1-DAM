package com.salesianostriana.dam.serranoruizmauro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.salesianostriana.dam.serranoruizmauro.service.CategoryService;

@Controller
public class MainController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public String mainWeb(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		return "PaginaPrincipal";
	}
	
	@GetMapping("/shipping-return")
	public String shippingReturnWeb(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		return "EnvioDevolucion";
	}
	
	@GetMapping("/faq")
	public String faqWeb(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		return "PreguntasFrecuentes";
	}
	
	@GetMapping("/customer-service")
	public String customerServiceWeb(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		return "Contacto";
	}
	
	@GetMapping("/privacy-policy")
	public String socialWeb(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		return "PoliticaPrivacidad";
	}
	
	@GetMapping("/terms-conditions")
	public String termsConditionsWeb(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		return "TerminosCondiciones";
	}
	
	@GetMapping("/cookies")
	public String cookiesWeb(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		return "Cookies";
	}
}
