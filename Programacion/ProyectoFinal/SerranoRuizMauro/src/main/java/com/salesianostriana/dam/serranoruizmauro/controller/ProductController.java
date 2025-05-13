package com.salesianostriana.dam.serranoruizmauro.controller;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
	public String filterCategory(Model model, @PathVariable(required = false) Long id,
			@RequestParam(name = "sort", required = false) Integer sort,
			@RequestParam(name = "search", required = false) String search) {

		Stream<Product> productStream = productService.findAll().stream().filter(Product::isVisible);
		List<Product> products;
		
		Map<Integer, Comparator<Product>> sortOptions = Map.of(0, Comparator.comparing(Product::getPrice), 1,
				Comparator.comparing(Product::getPrice).reversed(), 2, Comparator.comparing(Product::getName), 3,
				Comparator.comparing(Product::getName).reversed(), 4,
				Comparator.comparing(Product::getCreationDate).reversed());

		if (id != null) {
			productStream = productStream.filter(p -> p.getCategory().getId().equals(id));
			model.addAttribute("selectedCategoryId", id);
		} else {
			model.addAttribute("selectedCategoryId", id);
		}

		if (search != null) {
			productStream = productStream.filter(p -> p.getName().toLowerCase().contains(search.toLowerCase()));
		}
		
		products = productStream.collect(Collectors.toList());
		
		if (sort != null) {
			products.sort(sortOptions.get(sort));
	    }

		model.addAttribute("products", products);
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("resultCount", products.size());
		model.addAttribute("sort", sort);
		model.addAttribute("search", search);
		return "Tienda";
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
