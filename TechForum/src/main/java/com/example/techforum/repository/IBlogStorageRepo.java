package com.example.techforum.repository;

import com.example.techforum.model.BlogStorage;
import com.example.techforum.model.Likes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBlogStorageRepo extends JpaRepository<BlogStorage, Long> {
    Optional<BlogStorage> findBlogStoragesByBlogIdAndUserId(Long blogId, Long userId);
    int countByBlogId(Long blogId);
    Page<BlogStorage> findAllByUserId(Long userId, Pageable pageable);

}
