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

import com.project.edalpi.entities.Role;
import com.project.edalpi.services.RoleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private RoleService service;
	
	@GetMapping
	public List<Role> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Role> roleOptional = this.service.findById(id);
		return roleOptional.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(roleOptional.orElseThrow()) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "El rol con folio " + id + " no fue encontrado"));
	}
	
	@PostMapping
	public ResponseEntity<Role> save(@RequestBody Role role){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(role));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Role> update(@PathVariable Long id, @RequestBody Role role){
		Optional<Role> roleOptional = this.service.findById(id);
		if(roleOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Role newRole = roleOptional.get();
		newRole.setName(role.getName());
		return ResponseEntity.ok(this.service.save(newRole));
		
	}
}