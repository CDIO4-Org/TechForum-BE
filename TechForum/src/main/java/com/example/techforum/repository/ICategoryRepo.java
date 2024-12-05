package com.example.techforum.repository;

import com.example.techforum.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepo extends JpaRepository<Categories, Integer> {
    @Query(value = "select * from categories", nativeQuery = true)
    List<Categories> getAllCategories();
    Categories findById(Long id);
}
