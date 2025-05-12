package com.salesianostriana.dam.serranoruizmauro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.serranoruizmauro.repository.CategoryRepository;
import com.salesianostriana.dam.serranoruizmauro.model.Category;



@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	public List<Category> findAll(){
		return categoryRepo.findAll();
	}
	
}
