package com.example.microservicioAPITest.services;

import java.util.List;
import java.util.Optional;

import com.example.microservicioAPITest.model.Pet;

public interface PetService {
    boolean addPet(Pet pet);
    Pet updatePet(long idPet, Pet petUpdate);
    Optional<Pet> finByIdPet(long idPet);
    List<Pet> findAllPet();
    boolean deletePet(long idPet);
}
