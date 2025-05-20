package com.salesianostriana.dam.serranoruizmauro.model;

import java.time.LocalDateTime;

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

	private double price, discount;
	private String name, description, image, altText;
	private int stock;
	private boolean visible;
	private LocalDateTime creationDate;

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

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_product_brand"))
	private Brand brand;

	public void addToBrand(Brand brand) {
		this.brand = brand;
		brand.getProductsList().add(this);
	}

	public void removerFromBrand(Brand brand) {
		category.getProductsList().remove(this);
		this.brand = brand;
	}

	public double getFinalDiscount() {
		double brandDiscount = (this.getBrand() != null) ? this.getBrand().getDiscount() : 0.0;

		return Math.min(discount + brandDiscount, 100.00);
	}
	
	public double getDiscountedPrice() {
		return price * (1 - getFinalDiscount()/100);
	}
	
	public boolean isOnSale() {
	    return getFinalDiscount() > 0;
	}

}
