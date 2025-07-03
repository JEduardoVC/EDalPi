package com.project.edalpi.services;

import java.util.List;
import java.util.Optional;

import com.project.edalpi.entities.Delivery;

public interface DeliveryService {

	List<Delivery> findAll();

	Optional<Delivery> findById(Long id);

	Delivery save(Delivery delivery);

}
