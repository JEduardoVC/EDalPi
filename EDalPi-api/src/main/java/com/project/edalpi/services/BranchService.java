package com.project.edalpi.services;

import java.util.List;
import java.util.Optional;

import com.project.edalpi.entities.Branch;

public interface BranchService {
	
	List<Branch> findAll();
	
	Optional<Branch> findById(Long id);
	
	Branch save(Branch branch);
}
