package com.salesianostriana.dam.serranoruizmauro.controller;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.salesianostriana.dam.serranoruizmauro.model.Product;
import com.salesianostriana.dam.serranoruizmauro.model.Brand;
import com.salesianostriana.dam.serranoruizmauro.service.BrandService;
import com.salesianostriana.dam.serranoruizmauro.service.CategoryService;
import com.salesianostriana.dam.serranoruizmauro.service.ProductService;

import org.springframework.ui.Model;

@Controller
public class MainController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	BrandService brandService;

	// Página principal
	@GetMapping("/tablarota")
	public String mainWeb() {
		return "PaginaPrincipal";
	}

	// Marcas
	@GetMapping("/brands")
	public String showAllBrands(Model model) {
		List<Brand> brands = brandService.findAll();

		model.addAttribute("brands", brands);
		model.addAttribute("resultCount", brands.size());
		return "Marcas";
	}

	@GetMapping("/brands/search")
	public String brandProduct(String search, Model model) {
		List<Brand> results = brandService.findAll().stream()
				.filter(b -> b.getBrandName().toLowerCase().contains(search.toLowerCase()))
				.collect(Collectors.toList());

		model.addAttribute("brands", results);
		model.addAttribute("resultCount", results.size());
		model.addAttribute("search", search);

		return "Marcas";
	}

	@GetMapping("/createBrand")
	public String createBrandForm(Model model) {
		model.addAttribute("brand", new Brand());
		return "FormularioMarca";
	}

	@GetMapping("/modifyBrand/{id}")
	public String modifyFormBrand(Model model, @PathVariable Long id) {

		Optional<Brand> brandOpt = Optional.ofNullable(brandService.findById(id));

		if (brandOpt.isPresent()) {
			model.addAttribute("brand", brandOpt.get());
			return "FormularioMarca";
		} else {
			return "redirect:/brands";
		}
	}

	@PostMapping("/saveBrand")
	public String saveBrand(Brand brand) {
		brandService.save(brand);

		return "redirect:/brands";
	}

	@GetMapping("/deleteBrand/{id}")
	public String deleteBrand(@PathVariable Long id) {
		Optional<Brand> brandOpt = Optional.ofNullable(brandService.findById(id));

		brandOpt.ifPresent(p -> brandService.deleteById(id));

		return "redirect:/brands";
	}

	// Tienda
	@GetMapping({ "/shop", "/shop/{id}", "/shop/search"})
	public String filterCategory(Model model, @PathVariable(required = false) Long id,
			@RequestParam(name = "sort", required = false) Integer sort, @RequestParam(name = "search", required = false) String search) {
		List<Product> products;

		// Añadir la comprobacion con optional si no encuentra el producto

		if (id != null) {
			products = productService.findAll().stream().filter(Product::isVisible)
					.filter(p -> p.getCategory().getId().equals(id)).collect(Collectors.toList());
			model.addAttribute("selectedCategoryId", id);
		} else {
			products = productService.findAll().stream().filter(Product::isVisible).collect(Collectors.toList());
			model.addAttribute("selectedCategoryId", null);
		}

		if (sort != null) {
			switch (sort) {
			case 0:
				products.sort(Comparator.comparing(Product::getPrice));
				break;

			case 1:
				products.sort(Comparator.comparing(Product::getPrice).reversed());
				break;

			case 2:
				products.sort(Comparator.comparing(Product::getName));
				break;

			case 3:
				products.sort(Comparator.comparing(Product::getName).reversed());
				break;

			case 4:
				products.sort(Comparator.comparing(Product::getCreationDate).reversed());
				break;

			default:
				break;
			}
		}

		if (search != null) {
			products = productService.findAll().stream()
					.filter(p -> p.getName().toLowerCase().contains(search.toLowerCase())).filter(Product::isVisible)
					.collect(Collectors.toList());
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
		Optional<Product> productOpt = Optional.ofNullable(productService.findById(id));

		productOpt.ifPresent(p -> productService.deleteById(id));

		return "redirect:/shop";
	}

	@GetMapping("/modifyProduct/{id}")
	public String modifyForm(Model model, @PathVariable Long id) {

		Optional<Product> productOpt = Optional.ofNullable(productService.findById(id));

		if (productOpt.isPresent()) {
			model.addAttribute("categories", categoryService.findAll());
			model.addAttribute("brands", brandService.findAll());
			model.addAttribute("product", productOpt.get());

			return "FormularioProducto";
		} else {
			return "redirect:/shop";
		}
	}

//	@GetMapping("/shop/search")
//	public String searchProduct(@RequestParam("search") String search, Model model) {
//		List<Product> results = productService.findAll().stream()
//				.filter(p -> p.getName().toLowerCase().contains(search.toLowerCase())).filter(Product::isVisible)
//				.collect(Collectors.toList());
//
//		model.addAttribute("products", results);
//		model.addAttribute("categories", categoryService.findAll());
//		model.addAttribute("resultCount", results.size());
//		model.addAttribute("search", search);
//
//		return "Tienda";
//	}

}
