package com.project.edalpi.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.edalpi.entities.Product;
import com.project.edalpi.services.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductService service;
	
	@GetMapping
	public List<Product> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Product> productOptional = this.service.findById(id);
		return productOptional.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(productOptional.orElseThrow()) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "El producto con folio " + id + " no fue encontrado"));
	}
	
	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product product){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(product));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product){
		Optional<Product> productOptional = this.service.findById(id);
		if(productOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Product newProduct = productOptional.get();
		newProduct.setSize(product.getSize());
		newProduct.setDeliveryTime(product.getDeliveryTime());
		newProduct.setQuantity(product.getQuantity());
		newProduct.setPrice(product.getPrice());
		newProduct.setName(product.getName());
		newProduct.setType(product.getType());
		newProduct.setTimeUnit(product.getTimeUnit());
		newProduct.setOrders(product.getOrders());
		newProduct.setDeliveries(product.getDeliveries());
		return ResponseEntity.ok(this.service.save(newProduct));
	}
}
