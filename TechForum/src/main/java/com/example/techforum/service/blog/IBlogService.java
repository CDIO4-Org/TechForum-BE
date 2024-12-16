package com.example.techforum.service.blog;

import com.example.techforum.dto.BlogDto;
import com.example.techforum.dto.BlogDtoNew;
import com.example.techforum.model.Blogs;
import com.example.techforum.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Blogs updateBlog(Integer id, BlogDto updatedBlog);
    void acctiveBlog(Integer id);
    List<BlogDto> findByUser(Users user);
    Page<BlogDto> findByStatus(Boolean status, Pageable pageable);
    List<BlogDto> getAcctivedBlogs();
    Blogs addNewBlog(BlogDto blog);
    BlogDto findOne(Integer id);
    void delete(Integer id);
    List<BlogDto> findByTitle(String title);
    Integer getLastInsert();
    Blogs findById(Integer id);
    List<BlogDto> findByCategoryId(Integer id);
}
