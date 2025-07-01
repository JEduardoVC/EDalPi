package com.project.edalpi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.edalpi.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
