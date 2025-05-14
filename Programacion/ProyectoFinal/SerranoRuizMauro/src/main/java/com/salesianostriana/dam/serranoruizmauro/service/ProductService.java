package com.salesianostriana.dam.serranoruizmauro.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.salesianostriana.dam.serranoruizmauro.model.Product;
import com.salesianostriana.dam.serranoruizmauro.repository.ProductRepository;
import com.salesianostriana.dam.serranoruizmauro.service.base.BaseServiceImpl;

@Service
public class ProductService extends BaseServiceImpl<Product, Long, ProductRepository> {

	@Autowired
	private ProductRepository productRepo;

	public List<Product> getNotVisibleProducts() {
		return productRepo.findAllNoVisibleProducts();
	}

	public List<Product> getVisibleProducts() {
		return productRepo.findAllVisibleProducts();
	}

	public List<Product> getFilteredAndSortedProducts(Long categoryId, String search, Integer sort) {
		Stream<Product> productStream = getFilteredProductsStream(categoryId, search);
		List<Product> products = productStream.collect(Collectors.toList());

		if (sort != null) {
			products.sort(productComparator(sort));
		}

		return products;
	}

	private Stream<Product> getFilteredProductsStream(Long categoryId, String search) {
		Stream<Product> stream = getShuffledProducts().stream().filter(Product::isVisible);

		if (categoryId != null) {
			stream = stream.filter(p -> p.getCategory() != null && p.getCategory().getId().equals(categoryId));
		}

		if (search != null && !search.isBlank()) {
			stream = stream.filter(p -> p.getName().toLowerCase().contains(search.toLowerCase()));
		}

		return stream;
	}

	private Comparator<Product> productComparator(Integer sort) {
		Map<Integer, Comparator<Product>> sortOptions = Map.of(0, Comparator.comparing(Product::getDiscountedPrice), 1,
				Comparator.comparing(Product::getDiscountedPrice).reversed(), 2, Comparator.comparing(Product::getName),
				3, Comparator.comparing(Product::getName).reversed(), 4,
				Comparator.comparing(Product::getCreationDate).reversed());

		return sortOptions.getOrDefault(sort, Comparator.comparing(Product::getName));
	}

	public void unlinkCategory(Long Id) {
		List<Product> products = productRepo.findAll().stream()
				.filter(p -> p.getCategory() != null && p.getCategory().getId().equals(Id))
				.collect(Collectors.toList());

		if (!products.isEmpty()) {
			for (Product product : products) {
				product.setVisible(false);
				product.setCategory(null);
			}
			productRepo.saveAll(products);
		}
	}

	public void unlinkBrand(Long Id) {
		List<Product> products = productRepo.findAll().stream()
				.filter(p -> p.getBrand() != null && p.getBrand().getId().equals(Id)).collect(Collectors.toList());

		if (!products.isEmpty()) {
			for (Product product : products) {
				product.setVisible(false);
				product.setBrand(null);
			}
			productRepo.saveAll(products);
		}
	}

	public List<Product> getShuffledProducts() {
		List<Long> idsList = productRepo.findIds();
		Collections.shuffle(idsList);
		List<Product> products = productRepo.findAllById(idsList);

		products.sort(Comparator.comparingInt(p -> idsList.indexOf(p.getId())));

		return products;
	}

}
