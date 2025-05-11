package com.salesianostriana.dam.serranoruizmauro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double price;
	private String name, description, image, brand;
	private int stock;
	private boolean visible;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_product_category"))
	private Category category;
	
	public void addToCategory(Category category) {
		this.category = category;
		category.getProductsList().add(this);
	}
	
	public void removeFromCategory(Category category) {
		category.getProductsList().remove(this);
		this.category = null;		
	}
}
