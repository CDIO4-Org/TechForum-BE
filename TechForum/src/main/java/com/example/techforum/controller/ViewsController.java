package com.example.techforum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.techforum.service.views.IViewsService;

@RestController
@RequestMapping("/api/views")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class ViewsController {
    @Autowired
    private IViewsService viewsService;
    @PostMapping("/")
    public String toggleView(@RequestParam Long blogId, @RequestParam Long userId) {
        return viewsService.toggleView(blogId, userId);
    }

    @GetMapping("/countView")
    public int getLikeCount(@RequestParam Long blogId) {
        return viewsService.getViewCount(blogId);
    }
}
