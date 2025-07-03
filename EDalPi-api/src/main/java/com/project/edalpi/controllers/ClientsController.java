package com.project.edalpi.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.edalpi.entities.Client;
import com.project.edalpi.services.ClientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/clients")
public class ClientsController {
	@Autowired
	private ClientService service;
	
	@GetMapping
	public List<Client> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Client> clientOptional = this.service.findById(id);
		return clientOptional.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(clientOptional.orElseThrow()) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "El cliente con folio " + id + " no fue encontrado"));
	}
	
	@PostMapping
	public ResponseEntity<Client> save(@RequestBody Client client){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(client));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> update(@PathVariable Long id ,@RequestBody Client client){
		Optional<Client> clientOptional = this.service.findById(id);
		if(clientOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Client oldClient = clientOptional.get();
		oldClient.setPhoneNumber(client.getPhoneNumber());
		oldClient.setAdress(client.getAdress());
		oldClient.setUser(client.getUser());
		oldClient.setOrder(client.getOrder());
		return ResponseEntity.ok(this.service.save(oldClient));
	}

}
