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

@RestController
@RequestMapping("/api/storage")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class BlogStorageController {
    @Autowired
    private IBlogStorageService blogStorageService;
    @GetMapping("/getAll")
    public ResponseEntity<Page<BlogStorage>> getBlogNonActived(
            @RequestParam Long userId,
            @RequestParam(defaultValue = "0") int page, // Trang bắt đầu, mặc định là 0
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,desc") String[] sort
    ) {
        Sort.Direction direction = Sort.Direction.fromString(sort[1]);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort[0]));

        Page<BlogStorage> blogStorages = blogStorageService.findAllByUserId(userId, pageable);
        return ResponseEntity.ok(blogStorages);
    }

    @PostMapping("/")
    public String toggleBookmark(@RequestParam Long blogId, @RequestParam Long userId) {
        return blogStorageService.toggleBookMark(blogId, userId);
    }

    @GetMapping("/count")
    public int getBookmarkCount(@RequestParam Long blogId) {
        return blogStorageService.getCount(blogId);
    }
    @GetMapping("/checkExist")
    public Boolean isBookmark(@RequestParam Long blogId, @RequestParam Long userId) {
        return blogStorageService.isBlogBookMarkedByUser(blogId, userId);
    }
}
