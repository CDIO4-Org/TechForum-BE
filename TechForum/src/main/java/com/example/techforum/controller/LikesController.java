package com.example.techforum.controller;

import com.example.techforum.model.Likes;
import com.example.techforum.service.likes.ILikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/like")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class LikesController {
    @Autowired
    private ILikesService likesService;

    @GetMapping("/getAll")
    public ResponseEntity<Page<Likes>> getBlogLiked(
            @RequestParam Long userId,
            @RequestParam(defaultValue = "0") int page, // Trang bắt đầu, mặc định là 0
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,desc") String[] sort
    ) {
        Sort.Direction direction = Sort.Direction.fromString(sort[1]);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort[0]));

        Page<Likes> activeBlogs = likesService.findAll(userId, pageable);
        return ResponseEntity.ok(activeBlogs);
    }

    @PostMapping("/")
    public String toggleLike(@RequestParam Long blogId, @RequestParam Long userId) {
        return likesService.toggleLike(blogId, userId);
    }

    @GetMapping("/countLike")
    public int getLikeCount(@RequestParam Long blogId) {
        return likesService.getLikeCount(blogId);
    }
    @GetMapping("/liked")
    public Boolean isLiked(@RequestParam Long blogId, @RequestParam Long userId) {
        return likesService.isBlogLikedByUser(blogId, userId);
    }
}
