package com.example.techforum.service.views;

import com.example.techforum.repository.IViewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewsService implements IViewsService{
    @Autowired
    private IViewsRepo viewsRepo;
}
