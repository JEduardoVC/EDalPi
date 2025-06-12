package com.project.edalpi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.edalpi.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
