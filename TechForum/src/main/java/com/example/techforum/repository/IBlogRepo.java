package com.example.techforum.repository;

import com.example.techforum.dto.BlogDto;
import com.example.techforum.model.Blogs;
import com.example.techforum.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepo extends JpaRepository<Blogs, Long> {
    @Query("SELECT b FROM Blogs b WHERE b.status = true")
    Page<Blogs> findAllBlogStatusTrue(Pageable pageable);
    List<BlogDto> findByUser(Users user);
    @Query("SELECT b FROM Blogs b WHERE b.title LIKE %:title%")
    List<BlogDto> findByTitle(@Param("title") String title);
}
