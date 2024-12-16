package com.example.techforum.service.category;

import com.example.techforum.dto.BlogDto;
import com.example.techforum.dto.CategoryDto;
import com.example.techforum.model.Blogs;
import com.example.techforum.model.Categories;
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityNotFoundException;
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

    @Override
    public Categories addnewCate(CategoryDto categoryDto) {
        return categoryRepo.save(dtoToObject(categoryDto));
    }

    @Override
    public void deleteCate(int id) {
        if (categoryRepo.existsById(id)){
            categoryRepo.deleteById(id);
        }else {
            throw new EntityNotFoundException("Cate not found with id: " + id);
        }
    }

    public Categories dtoToObject(CategoryDto categoryDto){
        return new Categories(categoryDto);
    }


}
