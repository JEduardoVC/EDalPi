package com.project.edalpi.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "deliveries")
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime estimatedDate;

	private LocalDateTime deliveryDate;

	private String paymentMethod;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToOne
	@JoinColumn(name ="branch_id")
	private Branch branch;

	@ManyToMany
	@JoinTable(
	    name = "delivery_products",
	    joinColumns = @JoinColumn(name = "delivery_id"),
	    inverseJoinColumns = @JoinColumn(name = "product_id")
	)
	private List<Product> products;
}
