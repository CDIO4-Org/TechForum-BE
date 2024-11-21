package com.example.techforum.service.category;

import com.example.techforum.model.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.techforum.repository.ICategoryRepo;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepo categoryRepo;

    @Override
    public List<Categories> getCategories() {
        return categoryRepo.getAllCategories();
    }
}
