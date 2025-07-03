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

import com.project.edalpi.entities.User;
import com.project.edalpi.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/users")
public class UsersController {  
	@Autowired
	private UserService service;
	
	@GetMapping
	public List<User> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<User> userOptional = this.service.findById(id);
		return userOptional.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(userOptional.orElseThrow()) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "El usuario con folio " + id + " no fue encotrado"));		
	}
	
	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(user));
	}
	
	@PutMapping
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
		Optional<User> userOptional = this.service.findById(id);
		if(userOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		User oldUser = userOptional.get();
		oldUser.setName(user.getName());
		oldUser.setEmail(user.getEmail());
		oldUser.setPassword(user.getPassword());
		oldUser.setRole(user.getRole());
		return ResponseEntity.ok(this.service.save(oldUser));
		
	}
}
	
	