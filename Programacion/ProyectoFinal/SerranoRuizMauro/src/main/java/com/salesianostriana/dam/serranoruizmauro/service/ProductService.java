package com.salesianostriana.dam.serranoruizmauro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.serranoruizmauro.model.Product;
import com.salesianostriana.dam.serranoruizmauro.repository.ProductRepository;

@Service
public class ProductService{
	
	@Autowired
	private ProductRepository productRepo;
	
	public List<Product> findAll(){
		return productRepo.findAll();
	}
	
	public Optional<Product> findById(Long id) {
		return productRepo.findById(id);
	}
	
	public void addProduct(Product product) {
		productRepo.save(product);
	}
	
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}
	

	
	//Todos los metodos
}
