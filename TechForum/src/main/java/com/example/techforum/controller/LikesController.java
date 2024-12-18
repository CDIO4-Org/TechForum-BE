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

import java.util.List;

@RestController
@RequestMapping("/api/like")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class LikesController {
    @Autowired
    private ILikesService likesService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Likes>> getBlogLiked(@RequestParam Integer userId) {
        List<Likes> activeBlogs = likesService.findAll(userId);
        return ResponseEntity.ok(activeBlogs);
    }

    @PostMapping("/")
    public String toggleLike(@RequestParam Integer blogId, @RequestParam Integer userId) {
        return likesService.toggleLike(blogId, userId);
    }

    @GetMapping("/countLike")
    public int getLikeCount(@RequestParam Integer blogId) {
        return likesService.getLikeCount(blogId);
    }
    @GetMapping("/liked")
    public Boolean isLiked(@RequestParam Integer blogId, @RequestParam Integer userId) {
        return likesService.isBlogLikedByUser(blogId, userId);
    }
}
