package com.example.techforum.repository;

import com.example.techforum.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageRepo extends JpaRepository<Images, Integer> {
}
