package com.project.edalpi.services.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.edalpi.entities.Order;
import com.project.edalpi.repositories.OrderRepository;
import com.project.edalpi.services.OrderService;


@Service
public class OrderServiceImplementation implements OrderService {

	@Autowired
	OrderRepository repository;
	
	@Override
	public List<Order> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Order> findById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public Order save(Order order) {
		return this.repository.save(order);
	}

}
