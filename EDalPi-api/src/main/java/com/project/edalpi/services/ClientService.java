package com.project.edalpi.services;

import java.util.List;
import java.util.Optional;

import com.project.edalpi.entities.Client;

public interface ClientService {

	List<Client> findAll();

	Optional<Client> findById(Long id);

	Client save(Client client);

}
