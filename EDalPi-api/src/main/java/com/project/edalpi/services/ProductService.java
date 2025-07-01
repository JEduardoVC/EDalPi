package com.project.edalpi.services;

import java.util.List;
import java.util.Optional;

import com.project.edalpi.entities.Product;

public interface ProductService {
	
	List<Product> findAll();
	
	Optional<Product> findById(Long id);
	
	Product save(Product product);
	
}
