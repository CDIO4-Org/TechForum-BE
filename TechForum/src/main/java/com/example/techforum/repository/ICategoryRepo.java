package com.example.techforum.repository;

import com.example.techforum.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepo extends JpaRepository<Categories, Integer> {
}
