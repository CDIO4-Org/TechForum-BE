package com.example.techforum.controller;

import com.example.techforum.model.Categories;
import com.example.techforum.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/getAllCategory")
    public ResponseEntity<List<Categories>> getAllPosition() {
        List<Categories> positionList = categoryService.getCategories();
        if (positionList.isEmpty()) {
            return new ResponseEntity<List<Categories>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Categories>>(positionList, HttpStatus.OK);
    }
}
