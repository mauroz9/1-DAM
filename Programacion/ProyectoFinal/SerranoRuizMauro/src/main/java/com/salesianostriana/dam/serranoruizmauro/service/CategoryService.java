package com.salesianostriana.dam.serranoruizmauro.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.salesianostriana.dam.serranoruizmauro.repository.CategoryRepository;
import com.salesianostriana.dam.serranoruizmauro.service.base.BaseServiceImpl;
import com.salesianostriana.dam.serranoruizmauro.model.Category;

@Service
public class CategoryService extends BaseServiceImpl<Category, Long, CategoryRepository>{
	
	public Optional <Category> findByName(String categoryName){
		 
		return findAll().stream()
                 .filter(c -> categoryName.equalsIgnoreCase(c.getCategoryName()))
                 .findFirst();
	}
	
}
