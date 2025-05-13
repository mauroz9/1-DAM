package com.salesianostriana.dam.serranoruizmauro.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.salesianostriana.dam.serranoruizmauro.model.Brand;
import com.salesianostriana.dam.serranoruizmauro.repository.BrandRepository;
import com.salesianostriana.dam.serranoruizmauro.service.base.BaseServiceImpl;

@Service
public class BrandService extends BaseServiceImpl<Brand, Long, BrandRepository>{
	
	public Optional <Brand> findByName(String brandName){
		 
		return findAll().stream()
                 .filter(b -> brandName.equalsIgnoreCase(b.getBrandName()))
                 .findFirst();
	}
}
