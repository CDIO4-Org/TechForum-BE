package com.example.techforum.service.category;

import com.example.techforum.dto.CategoryDto;
import com.example.techforum.model.Categories;
import jakarta.mail.MessagingException;

import java.util.List;

public interface ICategoryService {
    List<Categories> getCategories();

    Categories addnewCate(CategoryDto categoryDto);

    void deleteCate(int id);
}
