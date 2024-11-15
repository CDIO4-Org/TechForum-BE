package com.example.techforum.repository;

import com.example.techforum.model.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepo extends JpaRepository<Blogs, Integer> {
}
