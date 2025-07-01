package com.project.edalpi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.edalpi.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
