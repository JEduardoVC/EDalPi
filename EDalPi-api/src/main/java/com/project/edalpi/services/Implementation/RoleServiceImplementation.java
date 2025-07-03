package com.project.edalpi.services.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.edalpi.entities.Role;
import com.project.edalpi.repositories.RoleRepository;
import com.project.edalpi.services.RoleService;

@Service
public class RoleServiceImplementation implements RoleService {

	@Autowired
	RoleRepository repository;

	@Override
	public List<Role> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Role> findById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public Role save(Role role) {
		return this.repository.save(role);
	}

}
