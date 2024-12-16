package com.example.techforum.repository;

import com.example.techforum.model.BlogStorage;
import com.example.techforum.model.Likes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBlogStorageRepo extends JpaRepository<BlogStorage, Integer> {
    Optional<BlogStorage> findBlogStoragesByBlogIdAndUserId(Integer blogId, Integer userId);
    int countByBlogId(Integer blogId);
    Page<BlogStorage> findAllByUserId(Integer userId, Pageable pageable);

}
