package com.example.techforum.controller;

import com.example.techforum.service.likes.ILikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/like")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class LikesController {
    @Autowired
    private ILikesService likesService;

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
