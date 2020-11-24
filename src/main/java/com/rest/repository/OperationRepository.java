package com.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.model.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Integer>{

}
