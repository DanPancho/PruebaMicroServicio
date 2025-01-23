package com.example.microservicioAPITest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservicioAPITest.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
