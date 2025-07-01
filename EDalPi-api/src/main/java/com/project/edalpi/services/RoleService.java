package com.project.edalpi.services;

import java.util.List;
import java.util.Optional;

import com.project.edalpi.entities.Role;

public interface RoleService {
	
	List<Role> findAll();
	
	Optional<Role> findById(Long id);
	
	Role save(Role role);

}
