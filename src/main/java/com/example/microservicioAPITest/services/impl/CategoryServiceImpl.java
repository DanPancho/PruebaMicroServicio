package com.example.microservicioAPITest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicioAPITest.model.Category;
import com.example.microservicioAPITest.repository.CategoryRepository;
import com.example.microservicioAPITest.services.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean addCategory(Category category) {
        try {
            categoryRepository.save(category);
            log.info("Category added successfully");      
            return true;
        } catch (Exception e) {
            log.error("Error adding category: " + e.getMessage());
            return false;
        }	
    }
    
}
