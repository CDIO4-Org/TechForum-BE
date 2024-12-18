package com.example.techforum.controller;

import com.example.techforum.model.BlogStorage;
import com.example.techforum.model.Likes;
import com.example.techforum.service.blogstorage.IBlogStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/storage")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class BlogStorageController {
    @Autowired
    private IBlogStorageService blogStorageService;
    @GetMapping("/getAll")
    public ResponseEntity<List<BlogStorage>> getBlogNonActived(@RequestParam Integer userId) {
        List<BlogStorage> blogStorages = blogStorageService.findAllByUserId(userId);
        return ResponseEntity.ok(blogStorages);
    }

    @PostMapping("/")
    public String toggleBookmark(@RequestParam Integer blogId, @RequestParam Integer userId) {
        return blogStorageService.toggleBookMark(blogId, userId);
    }

    @GetMapping("/count")
    public int getBookmarkCount(@RequestParam Integer blogId) {
        return blogStorageService.getCount(blogId);
    }
    @GetMapping("/checkExist")
    public Boolean isBookmark(@RequestParam Integer blogId, @RequestParam Integer userId) {
        return blogStorageService.isBlogBookMarkedByUser(blogId, userId);
    }
}
