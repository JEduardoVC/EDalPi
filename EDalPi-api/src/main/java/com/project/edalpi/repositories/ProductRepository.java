package com.project.edalpi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.edalpi.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
