package com.project.edalpi.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

	@ManyToMany(mappedBy = "products")
	private List<Delivery> deliveries;
}
