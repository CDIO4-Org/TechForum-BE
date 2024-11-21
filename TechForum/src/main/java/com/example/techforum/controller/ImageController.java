package com.example.techforum.controller;

import com.example.techforum.dto.ImageDto;
import com.example.techforum.model.Categories;
import com.example.techforum.model.Images;
import com.example.techforum.service.image.ImageProcessingService;
import com.example.techforum.service.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class ImageController {
    @Autowired
    private ImageProcessingService imageService;

    @Autowired
    private ImageService imageServiceS;

    @PostMapping("/create-img")
    public ResponseEntity<Void> createBlogImage(@RequestBody ImageDto imgDto) {
        imageService.createBlogImage(imgDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getAllImag")
    public ResponseEntity<List<Images>> getAllImg(){
        List<Images> imgList = imageServiceS.findAllImages();
        if (imgList.isEmpty()) {
            return new ResponseEntity<List<Images>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Images>>(imgList, HttpStatus.OK);
    }
}
