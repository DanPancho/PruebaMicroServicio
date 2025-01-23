package com.example.microservicioAPITest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.microservicioAPITest.model.Category;
import com.example.microservicioAPITest.services.CategoryService;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/addCategory")
    public Map<String, Object> postMethodName(@RequestBody Category category) {
        
        Boolean responseStatus = categoryService.addCategory(category);
        String message = responseStatus ? "Category added successfully" : "Error adding category";

        Map<String, Object> response =  new HashMap<>();

        response.put("success", responseStatus);
        response.put("message", message);

        log.info("Response: {}" , response);
        
        return response;
    }
    
}
