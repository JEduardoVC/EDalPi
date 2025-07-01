package com.project.edalpi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.edalpi.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
