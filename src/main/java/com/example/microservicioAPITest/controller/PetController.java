package com.example.microservicioAPITest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicioAPITest.model.Pet;
import com.example.microservicioAPITest.services.PetService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/pet")
@CrossOrigin(origins = "*")
@Slf4j
public  class PetController {
    @Autowired
    private PetService petService;

    @PostMapping("/addPet")
    public Map<String, Object> addPet(@Valid @RequestBody Pet pet) {
        
        Boolean responseStatus = petService.addPet(pet);
        String message = responseStatus ? "Pet added successfully" : "Error adding pet";

        Map<String, Object> response =  new HashMap<>();
        

        response.put("code", responseStatus ? "200" : "405");
        response.put("description", message);

        log.info("Response: {}" , response);
        
        return response;
    }

    @GetMapping("/getAllPets")
    public Map<String, Object> getAllPets() {
        List<Pet> pets = petService.findAllPet();
        Boolean responseStatus = !pets.isEmpty() ? true : false;

        Map<String, Object> response =  new HashMap<>();


        response.put("code", responseStatus ? "200" : "404");
        response.put("description", responseStatus ? "successful operation" : "Pet not found");
        response.put("pets", pets);

        log.info("Response: {}" , response);

        return response;
    }

    @GetMapping("/getPet/{id}")
    public Map<String, Object> getAllPetsById(@PathVariable("id") long id) {

        Optional<Pet> pet = petService.finByIdPet(id);
        Boolean responseStatus = pet.isPresent() ? true : false;
        
        Map<String, Object> response =  new HashMap<>();

        response.put("code", responseStatus ? "200" : "404");
        response.put("description", responseStatus ? "successful operation" : "Pet not found");
        response.put("pets", responseStatus ? pet.get() : "");

        log.info("Response: {}" , response);

        return response;
    }

    @PutMapping("/updatePet/{id}")
    public Map<String, Object> updatePet(@PathVariable("id") long id, @Valid @RequestBody Pet pet) {

        Pet petUpdated = petService.updatePet(id, pet);

        Boolean responseStatus = petUpdated != null ? true : false;

        Map<String, Object> response =  new HashMap<>();

        response.put("code", responseStatus ? "200" : "404");
        response.put("description", responseStatus ? "successful operation" : "Pet not found");
        response.put("pets", responseStatus ? petUpdated : "Pet not found");
        
        return response;
    }

    @PostMapping("/deletePet/{id}")
    public Map<String, Object> postMethodName(@PathVariable("id") long id) {
        Boolean responseStatus = petService.deletePet(id);
        String message = responseStatus ? "Pet deleted successfully" : "Error deleting pet";

        Map<String, Object> response =  new HashMap<>();

        response.put("code", responseStatus ? "200" : "404");
        response.put("description", message);

        log.info("Response: {}" , response);
        
        return response;
    }
    
    

    

}
