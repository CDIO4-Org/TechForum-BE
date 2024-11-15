package com.example.techforum.service.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.techforum.repository.IBlogRepo;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepo blogRepo;
}
