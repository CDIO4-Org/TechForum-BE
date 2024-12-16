package com.example.techforum.repository;

import com.example.techforum.model.Likes;
import com.example.techforum.model.Views;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IViewsRepo extends JpaRepository<Views, Integer> {
    Optional<Views> findByBlogIdAndUserId(Integer blogId, Integer userId);
    int countByBlogId(Integer postId);
}
