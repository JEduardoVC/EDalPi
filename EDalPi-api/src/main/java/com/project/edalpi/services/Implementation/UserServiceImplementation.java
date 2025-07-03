package com.project.edalpi.services.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.edalpi.entities.User;
import com.project.edalpi.repositories.UserRepository;
import com.project.edalpi.services.UserService;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public List<User> findAll(){
		return this.repository.findAll();
	}

	@Override
	public Optional<User> findById(Long id){
		return this.repository.findById(id);
	}

	@Override
	public User save(User user) {
		return this.repository.save(user);
	}
}
