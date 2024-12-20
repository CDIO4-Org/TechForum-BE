package com.example.techforum.repository;

import com.example.techforum.dto.BlogDto;
import com.example.techforum.model.Blogs;
import com.example.techforum.model.Categories;
import com.example.techforum.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Transactional
@Repository
public interface IBlogRepo extends JpaRepository<Blogs, Integer> {
    @Query("SELECT b from Blogs b where b.status = true ORDER BY b.beginDate DESC ")
    List<Blogs> findByStatusTrue();
    Page<Blogs> findByStatus(Boolean status, Pageable pageable);
    List<Blogs> getAllByUserId(Integer user);
    @Query("SELECT b FROM Blogs b WHERE b.title LIKE %:title% and b.status = true")
    List<BlogDto> findByTitle(@Param("title") String title);

    @Query(value = "select MAX(id) from blogs", nativeQuery = true)
    Integer getLastInsert();

    @Query(value = "select * from blogs where id = :id", nativeQuery = true)
    Blogs findObject(@Param("id") Integer id);
    @Query("SELECT b FROM Blogs b WHERE b.category = :categories and b.status = true")
    List<BlogDto> findAllByCategory(@Param("categories") Categories categories);
}
