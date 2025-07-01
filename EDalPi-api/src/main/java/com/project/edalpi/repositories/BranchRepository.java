package com.project.edalpi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.edalpi.entities.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

}
