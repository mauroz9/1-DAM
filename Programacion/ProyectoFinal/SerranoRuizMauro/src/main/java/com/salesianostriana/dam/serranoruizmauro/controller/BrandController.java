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

		return "brand/Marcas";
	}

	@GetMapping("/brands/search")
	public String brandSearch(String search, Model model) {
		List<Brand> results = brandService.searchByName(search);

		model.addAttribute("brands", results);
		model.addAttribute("resultCount", results.size());
		model.addAttribute("search", search);
		model.addAttribute("categories", categoryService.findAll());

		return "brand/Marcas";
	}

	@GetMapping("/create-brand")
	public String createBrandForm(Model model) {
		model.addAttribute("brand", new Brand());
		return "brand/FormularioMarca";
	}

	@GetMapping("/modify-brand/{id}")
	public String modifyBrandForm(Model model, @PathVariable Long id) {

		Optional<Brand> brandOpt = brandService.findById(id);

		if (brandOpt.isPresent()) {
			model.addAttribute("brand", brandOpt.get());
			return "brand/FormularioMarca";
		} else {
			return "redirect:/brands";
		}
	}

	@PostMapping("/save-brand")
	public String saveBrand(Brand brand) {

		if (brand.getId() != null) {
			Optional<Brand> oldBrand = brandService.findById(brand.getId());

			if (oldBrand.isPresent()) {
				if (!brand.getBrandName().equals(oldBrand.get().getBrandName())
						&& !brandService.findByName(brand.getBrandName()).isEmpty()) {
					return "redirect:/brands";
				}
			}
		} else if (!brandService.findByName(brand.getBrandName()).isEmpty()) {

			return "redirect:/brands";
		}

		brandService.save(brand);

		return "redirect:/brands";
	}

	@GetMapping("/delete-brand/{id}")
	public String deleteBrand(@PathVariable Long id) {
		Optional<Brand> brandOpt = brandService.findById(id);

		brandOpt.ifPresent(b -> {
			productService.unlinkBrand(id);
			brandService.deleteById(id);
		});

		return "redirect:/brands";
	}
}
