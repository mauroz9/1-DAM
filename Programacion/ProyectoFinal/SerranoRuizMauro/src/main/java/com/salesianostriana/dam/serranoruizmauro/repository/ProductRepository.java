package com.salesianostriana.dam.serranoruizmauro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.serranoruizmauro.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query("select p.id from Product p")
	public List<Long> findIds();

	@Query("SELECT p FROM Product p WHERE p.visible = false")
	public List<Product> findAllNoVisibleProducts();
	
	@Query("SELECT p FROM Product p WHERE p.visible = True")
	public List<Product> findAllVisibleProducts();
	
}
