package com.example.techforum.service.blog;

import com.example.techforum.dto.BlogDto;
import com.example.techforum.model.Blogs;
import com.example.techforum.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Blogs updateBlog(Long id, BlogDto updatedBlog);
    List<BlogDto> findByUser(Users user);
    Page<BlogDto> findAll(Pageable pageable);
    Page<BlogDto> findAllBlogStatusTrue(Pageable pageable);
    Blogs addNewBlog(BlogDto blog);
    BlogDto findOne(long id);
    void delete(long id);
    List<BlogDto> findByTitle(String title);
}
