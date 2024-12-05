package com.example.techforum.service.blogstorage;

import com.example.techforum.dto.CommentDto;
import com.example.techforum.model.BlogStorage;
import com.example.techforum.model.Comments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogStorageService {
    Page<BlogStorage> findAllByUserId(Long id,Pageable pageable);
    String toggleBookMark(Long blogId, Long userId);
    void delete(Long id);
    int getCount(Long blogId);
    Boolean isBlogBookMarkedByUser(Long blogId, Long userId);
}
