package com.project.edalpi.services.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.edalpi.entities.Delivery;
import com.project.edalpi.repositories.DeliveryRepository;
import com.project.edalpi.services.DeliveryService;

@Service
public class DeliveryServiceImplementation implements DeliveryService {
	
	@Autowired
	DeliveryRepository repository;

	@Override
	public List<Delivery> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Delivery> findById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public Delivery save(Delivery delivery) {
		return this.repository.save(delivery);
	}
	
	

}
