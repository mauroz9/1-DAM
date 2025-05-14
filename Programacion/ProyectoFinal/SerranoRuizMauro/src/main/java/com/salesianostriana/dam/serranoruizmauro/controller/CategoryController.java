package com.salesianostriana.dam.serranoruizmauro.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesianostriana.dam.serranoruizmauro.model.Category;
import com.salesianostriana.dam.serranoruizmauro.service.CategoryService;
import com.salesianostriana.dam.serranoruizmauro.service.ProductService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;

	
	@GetMapping("/categories")
	public String showAllCategories(Model model) {
		List<Category> categories = categoryService.findAll();

		model.addAttribute("categories", categories);
		model.addAttribute("resultCount", categories.size());
		return "Categorias";
	}

	@GetMapping("/createCategory")
	public String createCategoryForm(Model model) {
		model.addAttribute("category", new Category());
		return "FormularioCategoria";
	}

	@GetMapping("/modifyCategory/{id}")
	public String modifyCategoryForm(Model model, @PathVariable Long id) {

		Optional<Category> categoryOpt = categoryService.findById(id);

		if (categoryOpt.isPresent()) {
			model.addAttribute("category", categoryOpt.get());
			return "FormularioCategoria";
		} else {
			return "redirect:/categories";
		}
	}

	@PostMapping("/saveCategory")
	public String saveBrand(Category category) {
		Optional<Category> categoryOpt = Optional.ofNullable(category);
		
		if(categoryOpt.isPresent()) {
			if(categoryService.findByName(categoryOpt.get().getCategoryName()).isEmpty()){
				categoryService.save(categoryOpt.get());
			}
		}

		return "redirect:/categories";
	}

	@GetMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable Long id) {
		Optional<Category> categoryOpt = categoryService.findById(id);

		categoryOpt.ifPresent(c -> {
			productService.unlinkCategory(id);
			categoryService.deleteById(id);
		});

		return "redirect:/categories";
	}
}
