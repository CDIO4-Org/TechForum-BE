package com.example.techforum.controller;

import com.example.techforum.dto.BlogDto;
import com.example.techforum.dto.CategoryDto;
import com.example.techforum.model.Blogs;
import com.example.techforum.model.Categories;
import com.example.techforum.service.category.ICategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addNewCategory")
    public ResponseEntity<Categories> addnewCate(@RequestBody @Valid CategoryDto categoryDto) {
        Categories categories = categoryService.addnewCate(categoryDto);
        return new ResponseEntity<>(categories, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCategory")
    public ResponseEntity<String> deleteCate(@RequestParam int id){
        categoryService.deleteCate(id);
        return new ResponseEntity<>("Xoa thanh cong",HttpStatus.OK);
    }
}
