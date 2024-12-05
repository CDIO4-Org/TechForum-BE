package com.example.techforum.service.comment;

import com.example.techforum.dto.CommentDto;
import com.example.techforum.model.Comments;

import java.util.List;

public interface ICommentService {
    List<CommentDto> findAllCommentByBlogId(Long id);
    Comments save(CommentDto commentBlog);
    void delete(Long id);
    int getCommentCount(Long blogId);

}
