package com.salesianostriana.dam.serranoruizmauro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.salesianostriana.dam.serranoruizmauro.model.Category;
import com.salesianostriana.dam.serranoruizmauro.service.CategoryService;

@Controller
public class MainController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/tablarota")
	public String mainWeb(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		return "PaginaPrincipal";
	}
	
	@ModelAttribute("categories")
	public List<Category> obtainCategories(){
		return categoryService.findAll();
	}

}
