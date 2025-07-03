package com.project.edalpi.dtos;

import java.util.List;

import com.project.edalpi.entities.Delivery;
import com.project.edalpi.entities.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
	private int deliveryTime;
	private int quantity;
	private float price;
	private String name;
	private String type;
	private String timeUnit;
	private List<Order> orders;
	private List<Delivery> deliveries;
}
