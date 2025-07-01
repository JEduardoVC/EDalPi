package com.project.edalpi.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int size;
	
	private int deliveryTime;
	
	private int quantity;
	
	private float price;
	
	private String name;
	
	private String type;
	
	private String timeUnit;
	
	@ManyToMany(mappedBy = "products")
	private List<Order> orders;
	
	@ManyToOne
	@JoinColumn(name = "delivery_id")
	private Delivery delivery;
}
