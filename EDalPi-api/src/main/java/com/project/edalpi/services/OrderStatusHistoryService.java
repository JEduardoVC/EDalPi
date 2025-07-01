package com.project.edalpi.services;

import java.util.List;
import java.util.Optional;

import com.project.edalpi.entities.OrderStatusHistory;

public interface OrderStatusHistoryService {

	List<OrderStatusHistory> findAll();
	
	Optional<OrderStatusHistory> findById(Long id);
	
	OrderStatusHistory save(OrderStatusHistory orderStatusHistory);
}
