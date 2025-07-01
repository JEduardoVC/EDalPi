package com.project.edalpi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.edalpi.entities.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}
