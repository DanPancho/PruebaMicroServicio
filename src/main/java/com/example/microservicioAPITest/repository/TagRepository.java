package com.example.microservicioAPITest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservicioAPITest.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    
}
