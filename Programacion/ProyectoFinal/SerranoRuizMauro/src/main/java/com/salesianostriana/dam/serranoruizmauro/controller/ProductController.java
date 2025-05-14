package com.salesianostriana.dam.serranoruizmauro.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.serranoruizmauro.model.Product;
import com.salesianostriana.dam.serranoruizmauro.service.BrandService;
import com.salesianostriana.dam.serranoruizmauro.service.CategoryService;
import com.salesianostriana.dam.serranoruizmauro.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private BrandService brandService;

	@GetMapping({ "/shop", "/shop/{id}", "/shop/search" })
	public String showProducts(Model model,
			@PathVariable(required = false) Long id,
			@RequestParam(name = "sort", required = false) Integer sort,
			@RequestParam(name = "search", required = false) String search) {

		List<Product> products = productService.getFilteredAndSortedProducts(id, search, sort);

		model.addAttribute("products", products);
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("resultCount", products.size());
		model.addAttribute("sort", sort);
		model.addAttribute("search", search);
		model.addAttribute("selectedCategoryId", id);

		return "Tienda";
	}

	@GetMapping({ "/sale-products", "/sale-products/{id}", "/sale-products/search" })
	public String showDiscountProducts(Model model,
			@PathVariable(required = false) Long id,
			@RequestParam(name = "sort", required = false) Integer sort,
			@RequestParam(name = "search", required = false) String search) {

		Stream<Product> productStream = productService.getFilteredAndSortedProducts(id, search, sort).stream().filter(p -> p.getDiscount()>0);
		List <Product> products = productStream.collect(Collectors.toList());
		
		model.addAttribute("products", products);
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("resultCount", products.size());
		model.addAttribute("sort", sort);
		model.addAttribute("search", search);
		model.addAttribute("selectedCategoryId", id);

		return "TiendaSale";
	}

	@GetMapping("/createProduct")
	public String createProductForm(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("brands", brandService.findAll());
		model.addAttribute("product", new Product());
		return "FormularioProducto";
	}

	@PostMapping("/saveProduct")
	public String saveProduct(Product product) {
		if (product.getId() == null) {
			product.setCreationDate(LocalDateTime.now().withNano(0));
		}

		productService.save(product);
		return "redirect:/shop";
	}

	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable Long id) {
		Optional<Product> productOpt = productService.findById(id);
		productOpt.ifPresent(p -> productService.deleteById(id));
		return "redirect:/shop";
	}

	@GetMapping("/modifyProduct/{id}")
	public String modifyForm(Model model, @PathVariable Long id) {
		Optional<Product> productOpt = productService.findById(id);

		if (productOpt.isPresent()) {
			model.addAttribute("categories", categoryService.findAll());
			model.addAttribute("brands", brandService.findAll());
			model.addAttribute("product", productOpt.get());
			return "FormularioProducto";
		} else {
			return "redirect:/shop";
		}
	}
}
