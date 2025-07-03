package com.project.edalpi.dtos;

import java.util.List;

import com.project.edalpi.entities.Order;
import com.project.edalpi.entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO {
	private int phoneNumber;
	private String adress;
	private User user;
	private List<Order> orders;
}
