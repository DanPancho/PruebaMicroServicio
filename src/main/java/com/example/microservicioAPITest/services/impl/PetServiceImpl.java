package com.example.microservicioAPITest.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicioAPITest.model.Pet;
import com.example.microservicioAPITest.repository.PetRepository;
import com.example.microservicioAPITest.services.PetService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public boolean addPet(Pet pet) {
        try {
            petRepository.save(pet);
            log.info("Pet saved successfully");
            return true;
        }catch (Exception e) {
            log.error("Error saving pet: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Pet updatePet(long idPet, Pet petUpdate) {

        if(finByIdPet(idPet).isPresent()){
            if(finByIdPet(idPet).get().getId() == idPet){
                petRepository.save(petUpdate);
                return petUpdate;
            }
        }
        return null;
        
    }

    @Override
    public Optional<Pet> finByIdPet(long idPet) {
        try {
            return petRepository.findById(idPet);
        }catch(Exception e){
            log.error("Error deleting pet: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Pet> findAllPet() {
        List<Pet> pets = petRepository.findAll();
        return pets;
    }

    @Override
    public boolean deletePet(long idPet) {
        try {
            petRepository.deleteById(idPet);
            return true;
        }catch(Exception e){
            log.error("Error deleting pet: " + e.getMessage());
            return false;
        }
    }
    
}
