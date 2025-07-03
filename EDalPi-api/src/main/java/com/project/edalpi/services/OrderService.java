package com.project.edalpi.services;

import java.util.List;
import java.util.Optional;

import com.project.edalpi.entities.Order;

public interface OrderService {

	List<Order> findAll();

	Optional<Order> findById(Long id);

	Order save(Order order);
}
