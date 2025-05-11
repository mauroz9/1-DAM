package com.salesianostriana.dam.serranoruizmauro.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.serranoruizmauro.model.Category;
import com.salesianostriana.dam.serranoruizmauro.model.Product;
import com.salesianostriana.dam.serranoruizmauro.service.CategoryService;
import com.salesianostriana.dam.serranoruizmauro.service.ProductService;

import org.springframework.ui.Model;

@Controller
public class MainController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/tablarota")
	public String mainWeb() {
		return "PaginaPrincipal";
	}

	/*
	 * @GetMapping("/shop") public String getProducts(Model model) { List<Product>
	 * products = productService.findAll().stream().filter(Product::isVisible)
	 * .collect(Collectors.toList()); List<Category> categories =
	 * categoryService.findAll();
	 * 
	 * model.addAttribute("products", products); model.addAttribute("categories",
	 * categories); model.addAttribute("resultCount", products.size());
	 * 
	 * return "Tienda"; }
	 * 
	 * @GetMapping("/shop/{id}") public String filterCategory(Model
	 * model, @PathVariable Long id) { List<Category> categories =
	 * categoryService.findAll();
	 * 
	 * List<Product> products = productService.findAll().stream() .filter(p ->
	 * p.isVisible() && p.getCategory().getId() == (id))
	 * .collect(Collectors.toList());
	 * 
	 * model.addAttribute("products", products); model.addAttribute("categories",
	 * categories); model.addAttribute("selectedCategory", id);
	 * model.addAttribute("resultCount", products.size());
	 * 
	 * return "Tienda"; }
	 */

	@GetMapping({ "/shop", "/shop/{id}" })
	public String filterCategory(Model model, @PathVariable(required = false) Long id) {
		List<Product> products;
		
		if (id != null) {
			products = productService.findAll().stream().filter(Product::isVisible)
					.filter(p -> p.getCategory().getId().equals(id)).collect(Collectors.toList());
			model.addAttribute("selectedCategoryId", id);
		} else {
			products = productService.findAll().stream().filter(Product::isVisible).collect(Collectors.toList());
			model.addAttribute("selectedCategoryId", null);
		}
		
		model.addAttribute("products", products);
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("resultCount", products.size());
		return "Tienda";
	}

	@GetMapping("/createProduct")
	public String createForm(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("product", new Product());
		return "FormularioProducto";
	}

	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.addProduct(product);
		return "redirect:/shop";
	}

	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);

		return "redirect:/shop";
	}

	@GetMapping("/modifyProduct/{id}")
	public String modifyForm(Model model, @PathVariable Long id) {
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("product", productService.findById(id));
		return "FormularioProducto";
	}

}
