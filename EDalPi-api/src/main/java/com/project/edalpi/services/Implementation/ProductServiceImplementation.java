package com.project.edalpi.services.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.edalpi.entities.Product;
import com.project.edalpi.repositories.ProductRepository;
import com.project.edalpi.services.ProductService;

@Service
public class ProductServiceImplementation implements ProductService {

	@Autowired
	ProductRepository repository;
		
	@Override
	public List<Product> findAll(){
		return this.repository.findAll();
	}
	
	@Override
	public Optional<Product> findById(Long id){
		return this.repository.findById(id);
	}
	
	@Override
	public Product save(Product product) {
		return this.repository.save(product);
	}
}
