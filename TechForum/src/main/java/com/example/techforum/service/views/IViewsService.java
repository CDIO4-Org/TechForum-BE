package com.example.techforum.service.views;

public interface IViewsService {
    String toggleView(Long blogId, Long userId);
    int getViewCount(Long blogId);
}
