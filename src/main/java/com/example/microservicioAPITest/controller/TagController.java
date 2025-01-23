package com.example.microservicioAPITest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicioAPITest.model.Tag;
import com.example.microservicioAPITest.services.TagService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/tag")
@CrossOrigin(origins = "*")
@Slf4j
public class TagController {
    @Autowired
    private TagService tagService;

    @PostMapping("/addTag")
    public Map<String, Object> postMethodName(@RequestBody Tag tag) {
        
        Boolean responseStatus = tagService.addTag(tag);
        String message = responseStatus ? "Tag added successfully" : "Error adding tag";

        Map<String, Object> response =  new HashMap<>();

        response.put("success", responseStatus);
        response.put("message", message);

        log.info("Response: {}" , response);
        
        return response;
    }
}
