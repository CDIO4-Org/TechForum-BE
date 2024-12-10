package com.example.techforum.repository;

import com.example.techforum.model.Comments;
import com.example.techforum.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepo extends JpaRepository<Comments, Long> {
    @Query("SELECT c FROM Comments c WHERE c.blog.id = :id ORDER BY c.date DESC ")
    List<Comments> findAllByBlogId(@Param("id") Long id);
    int countByBlogId(Long postId);

}
