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

	@GetMapping({ "/shop", "/shop/{categoryId}", "/shop/search"})
	public String showProducts(Model model,
			@PathVariable(required = false) Long categoryId,
			@RequestParam(name = "brand", required = false) Long brandId,
			@RequestParam(name = "sort", required = false) Integer sort,
			@RequestParam(name = "search", required = false) String search) {

		Stream<Product> productsStream = productService.getFilteredAndSortedProducts(categoryId, search, sort, brandId).stream().filter(Product::isVisible);
		List <Product> products = productsStream.collect(Collectors.toList());
		
		model.addAttribute("products", products);
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("resultCount", products.size());
		model.addAttribute("sort", sort);
		model.addAttribute("search", search);
		model.addAttribute("selectedCategoryId", categoryId);

		return "product/Tienda";
	}

	@GetMapping({ "/shop/sale-products", "/shop/sale-products/{categoryId}", "/shop/sale-products/search" })
	public String showDiscountProducts(Model model,
			@PathVariable(required = false) Long categoryId,
			@RequestParam(name = "sort", required = false) Integer sort,
			@RequestParam(name = "search", required = false) String search,
			@RequestParam(name = "brand", required = false) Long brandId) {

		Stream<Product> productStream = productService.getFilteredAndSortedProducts(categoryId, search, sort, brandId).stream().filter(Product::isVisible).filter(Product::isOnSale);
		List <Product> products = productStream.collect(Collectors.toList());
		
		model.addAttribute("products", products);
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("resultCount", products.size());
		model.addAttribute("sort", sort);
		model.addAttribute("search", search);
		model.addAttribute("selectedCategoryId", categoryId);

		return "product/TiendaSale";
	}
	
	@GetMapping({ "/shop/hidden-products", "/shop/hidden-products/{categoryId}", "/shop/hidden-products/search" })
	public String showHiddenProducts(Model model,
			@PathVariable(required = false) Long categoryId,
			@RequestParam(name = "sort", required = false) Integer sort,
			@RequestParam(name = "search", required = false) String search,
			@RequestParam(name = "brand", required = false) Long brandId) {

		Stream<Product> productStream = productService.getFilteredAndSortedProducts(categoryId, search, sort, brandId).stream().filter(p -> !p.isVisible());
		List <Product> products = productStream.collect(Collectors.toList());
		
		model.addAttribute("products", products);
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("resultCount", products.size());
		model.addAttribute("sort", sort);
		model.addAttribute("search", search);
		model.addAttribute("selectedCategoryId", categoryId);

		return "product/TiendaOcultos";
	}

	@GetMapping("/create-product")
	public String createProductForm(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("brands", brandService.findAll());
		model.addAttribute("product", new Product());
		return "product/FormularioProducto";
	}

	@PostMapping("/save-product")
	public String saveProduct(Product product) {
		if (product.getId() == null) {
			product.setCreationDate(LocalDateTime.now().withNano(0));
		}

		productService.save(product);
		return "redirect:/shop";
	}

	@GetMapping("/delete-product/{id}")
	public String deleteProduct(@PathVariable Long id) {
		Optional<Product> productOpt = productService.findById(id);
		productOpt.ifPresent(p -> productService.deleteById(id));
		return "redirect:/shop";
	}

	@GetMapping("/modify-product/{id}")
	public String modifyForm(Model model, @PathVariable Long id) {
		Optional<Product> productOpt = productService.findById(id);

		if (productOpt.isPresent()) {
			model.addAttribute("categories", categoryService.findAll());
			model.addAttribute("brands", brandService.findAll());
			model.addAttribute("product", productOpt.get());
			return "product/FormularioProducto";
		} else {
			return "redirect:/shop";
		}
	}
	
	@GetMapping({"/shop/product/{productId}", "/shop/hidden-products/product/{productId}", "/shop/sale-products/product/{productId}"})
	public String showProductDetails(@PathVariable Long productId, Model model) {
	    Optional<Product> productOpt = productService.findById(productId);
	    
	    if (productOpt.isPresent()) {
	        model.addAttribute("product", productOpt.get());
	        model.addAttribute("categories", categoryService.findAll());
	        return "product/DetallesProducto";
	    } else {
	        return "redirect:/shop";
	    }
	}
}
