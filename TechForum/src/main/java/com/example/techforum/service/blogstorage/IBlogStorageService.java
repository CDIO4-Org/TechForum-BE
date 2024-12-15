package com.example.techforum.service.blogstorage;

import com.example.techforum.dto.CommentDto;
import com.example.techforum.model.BlogStorage;
import com.example.techforum.model.Comments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogStorageService {
    Page<BlogStorage> findAllByUserId(Integer id,Pageable pageable);
    String toggleBookMark(Integer blogId, Integer userId);
    void delete(Integer id);
    int getCount(Integer blogId);
    Boolean isBlogBookMarkedByUser(Integer blogId, Integer userId);
}
