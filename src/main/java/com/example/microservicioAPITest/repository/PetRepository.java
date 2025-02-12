package com.example.microservicioAPITest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservicioAPITest.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    
}
