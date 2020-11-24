package com.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.model.Emetteur;

@Repository
public interface EmetteurRepository extends JpaRepository<Emetteur, Integer> {

}
