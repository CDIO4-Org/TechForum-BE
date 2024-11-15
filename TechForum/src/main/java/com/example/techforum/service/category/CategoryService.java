package com.example.techforum.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.techforum.repository.ICategoryRepo;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepo categoryRepo;
}
