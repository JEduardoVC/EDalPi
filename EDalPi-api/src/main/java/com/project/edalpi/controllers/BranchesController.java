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

import com.project.edalpi.entities.Branch;
import com.project.edalpi.services.BranchService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/branches")
public class BranchesController {
	
	@Autowired
	private BranchService service;
	
	@GetMapping
	public List<Branch> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Branch> branchOptional = this.service.findById(id);
		return branchOptional.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(branchOptional.orElseThrow()) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "La sucursal con folio " + id + " no fue encontrada"));
	}
	
	@PostMapping
	public ResponseEntity<Branch> save(@RequestBody Branch branch){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(branch));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Branch> update(@PathVariable Long id, @RequestBody Branch branch){
		Optional<Branch> branchOptional = this.service.findById(id);
		if(branchOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Branch oldBranch = branchOptional.get();
		oldBranch.setLocation(branch.getLocation());
		oldBranch.setName(branch.getName());
		return ResponseEntity.ok(this.service.save(oldBranch));
	}
}
