package com.example.techforum.repository;

import com.example.techforum.model.Comments;
import com.example.techforum.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepo extends JpaRepository<Comments, Integer> {
    @Query("SELECT c FROM Comments c WHERE c.blog.id = :id ORDER BY c.date DESC ")
    List<Comments> findAllByBlogId(@Param("id") Integer id);
    int countByBlogId(Integer postId);

}
