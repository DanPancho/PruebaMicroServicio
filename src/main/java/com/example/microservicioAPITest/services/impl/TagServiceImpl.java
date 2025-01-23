package com.example.microservicioAPITest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicioAPITest.model.Tag;
import com.example.microservicioAPITest.repository.TagRepository;
import com.example.microservicioAPITest.services.TagService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;

    @Override
    public boolean addTag(Tag tag) {
        try {
            tagRepository.save(tag);
            log.info("Tag saved successfully");
            return true;
        } catch (Exception e) {
            log.error("Error saving tag: " + e.getMessage());
            return false;
        }
    }
    
}
