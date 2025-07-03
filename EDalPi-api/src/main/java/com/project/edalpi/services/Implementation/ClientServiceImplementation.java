package com.project.edalpi.services.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.edalpi.entities.Client;
import com.project.edalpi.repositories.ClientRepository;
import com.project.edalpi.services.ClientService;

@Service
public class ClientServiceImplementation implements ClientService {

	@Autowired
	ClientRepository repository;

	@Override
	public List<Client> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Client> findById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public Client save(Client client) {
		return this.repository.save(client);
	}

}
