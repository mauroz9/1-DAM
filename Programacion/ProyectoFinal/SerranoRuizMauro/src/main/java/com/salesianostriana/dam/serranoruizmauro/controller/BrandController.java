package com.salesianostriana.dam.serranoruizmauro.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesianostriana.dam.serranoruizmauro.model.Brand;
import com.salesianostriana.dam.serranoruizmauro.service.BrandService;
import com.salesianostriana.dam.serranoruizmauro.service.CategoryService;
import com.salesianostriana.dam.serranoruizmauro.service.ProductService;

@Controller
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	
	@GetMapping("/brands")
	public String showAllBrands(Model model) {
		List<Brand> brands = brandService.findAll();

		model.addAttribute("brands", brands);
		model.addAttribute("resultCount", brands.size());
		model.addAttribute("categories", categoryService.findAll());
		
		return "Marcas";
	}

	@GetMapping("/brands/search")
	public String brandSearch(String search, Model model) {
		List<Brand> results = brandService.searchByName(search);

		model.addAttribute("brands", results);
		model.addAttribute("resultCount", results.size());
		model.addAttribute("search", search);
		model.addAttribute("categories", categoryService.findAll());

		return "Marcas";
	}

	@GetMapping("/createBrand")
	public String createBrandForm(Model model) {
		model.addAttribute("brand", new Brand());
		return "FormularioMarca";
	}

	@GetMapping("/modifyBrand/{id}")
	public String modifyBrandForm(Model model, @PathVariable Long id) {

		Optional<Brand> brandOpt = brandService.findById(id);

		if (brandOpt.isPresent()) {
			model.addAttribute("brand", brandOpt.get());
			return "FormularioMarca";
		} else {
			return "redirect:/brands";
		}
	}

	@PostMapping("/saveBrand")
	public String saveBrand(Brand brand) {
		Optional <Brand> brandOpt = Optional.of(brand);
		
		if(brandOpt.isPresent()) {
			if(brandService.findByName(brandOpt.get().getBrandName()).isEmpty()) {
				brandService.save(brandOpt.get());
			}
		}

		return "redirect:/brands";
	}

	@GetMapping("/deleteBrand/{id}")
	public String deleteBrand(@PathVariable Long id) {
		Optional<Brand> brandOpt = brandService.findById(id);

		brandOpt.ifPresent(b -> {
			productService.unlinkBrand(id);
			brandService.deleteById(id);
		});

		return "redirect:/brands";
	}
}
