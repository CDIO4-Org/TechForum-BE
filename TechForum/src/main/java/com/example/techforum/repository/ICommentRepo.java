package com.example.techforum.repository;

import com.example.techforum.model.Comments;
import com.example.techforum.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepo extends JpaRepository<Comments, Long> {
    List<Comments> findAllByBlogId(Long id);
}
