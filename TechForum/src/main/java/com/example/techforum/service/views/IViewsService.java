package com.example.techforum.service.views;

public interface IViewsService {
    String toggleView(Integer blogId, Integer userId);
    int getViewCount(Integer blogId);
}
