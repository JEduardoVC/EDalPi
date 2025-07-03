package com.project.edalpi.services;

import java.util.List;
import java.util.Optional;

import com.project.edalpi.entities.User;

public interface UserService {

	List<User> findAll();

	Optional<User> findById(Long id);

	User save(User user);
}
