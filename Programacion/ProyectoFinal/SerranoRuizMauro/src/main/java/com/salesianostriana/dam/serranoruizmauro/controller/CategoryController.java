package com.salesianostriana.dam.serranoruizmauro.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		return "category/Categorias";
	}

	@GetMapping("/create-category")
	public String createCategoryForm(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("categories", categoryService.findAll());
		return "category/FormularioCategoria";
	}

	@GetMapping("/modify-category/{id}")
	public String modifyCategoryForm(Model model, @PathVariable Long id) {

		Optional<Category> categoryOpt = categoryService.findById(id);

		if (categoryOpt.isPresent()) {
			model.addAttribute("category", categoryOpt.get());
			model.addAttribute("categories", categoryService.findAll());
			return "category/FormularioCategoria";
		} else {
			return "redirect:/categories";
		}
	}

	@PostMapping("/save-category")
	public String saveBrand(Category category, RedirectAttributes redirectAttributes) {
		Optional<Category> categoryOpt = Optional.ofNullable(category);

		if (categoryOpt.isPresent()) {
			if (categoryService.findByName(categoryOpt.get().getCategoryName()).isEmpty()) {
				categoryService.save(categoryOpt.get());
				redirectAttributes.addFlashAttribute("successMessage", "Categoría guardada correctamente");
			}else {
				redirectAttributes.addFlashAttribute("errorMessage", "No se puede guardar la categoría porque ya existe una con ese nombre");
			}
			
		}

		return "redirect:/categories";
	}

	@GetMapping("/delete-category/{id}")
	public String deleteCategory(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		Optional<Category> categoryOpt = categoryService.findById(id);

		if (categoryOpt.isPresent()) {
			productService.unlinkCategory(id);
			categoryService.deleteById(id);
			redirectAttributes.addFlashAttribute("successMessage", "Categoría eliminada correctamente");
		} else {
			redirectAttributes.addFlashAttribute("errorMessage", "La categoría no existe o ya fue eliminada");
		}

		return "redirect:/categories";
	}

}
