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

import com.project.edalpi.entities.Order;
import com.project.edalpi.services.OrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	public List<Order> findAll(){
		return this.service.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Order> orderOptional = this.service.findById(id);
		return orderOptional.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(orderOptional.orElseThrow()) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "El pedido con folio " + id + " no fue encontrado"));
	}
	
	@PostMapping
	public ResponseEntity<Order> save(@RequestBody Order order){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(order));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order order){
		Optional<Order> orderOptional = this.service.findById(id);
		if(orderOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Order oldOrder = orderOptional.get();
		oldOrder.setClient(order.getClient());
		oldOrder.setStatus(order.getStatus());
		oldOrder.setBranch(order.getBranch());
		oldOrder.setProducts(order.getProducts());
		return ResponseEntity.ok(this.service.save(oldOrder));
	}
}
