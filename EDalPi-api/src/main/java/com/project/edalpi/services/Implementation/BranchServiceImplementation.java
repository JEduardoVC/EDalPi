package com.project.edalpi.services.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.edalpi.entities.Branch;
import com.project.edalpi.repositories.BranchRepository;
import com.project.edalpi.services.BranchService;

@Service
public class BranchServiceImplementation implements BranchService {

	@Autowired
	BranchRepository repository;

	@Override
	public List<Branch> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Branch> findById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public Branch save(Branch branch) {
		return this.repository.save(branch);
	}

}
