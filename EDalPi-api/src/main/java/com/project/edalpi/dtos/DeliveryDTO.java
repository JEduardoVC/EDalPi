package com.project.edalpi.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.project.edalpi.entities.Branch;
import com.project.edalpi.entities.Client;
import com.project.edalpi.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryDTO {
	private LocalDateTime estimatedDate;
	private LocalDateTime deliveryDate;
	private String paymentMethod;
	
	private Client client;
	private Branch branch;
	
	private List<Product> products;
}
