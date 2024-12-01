package com.example.techforum.repository;

import com.example.techforum.model.Likes;
import com.example.techforum.model.Views;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IViewsRepo extends JpaRepository<Views, Long> {
    Optional<Views> findByBlogIdAndUserId(Long blogId, Long userId);
    int countByBlogId(Long postId);
}
