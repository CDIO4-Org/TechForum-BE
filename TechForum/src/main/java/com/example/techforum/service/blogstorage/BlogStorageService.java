package com.example.techforum.service.blogstorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.techforum.repository.IBlogStorageRepo;

@Service
public class BlogStorageService implements IBlogStorageService {
    @Autowired
    private IBlogStorageRepo blogStorageRepo;
}
