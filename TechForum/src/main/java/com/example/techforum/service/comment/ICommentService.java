package com.example.techforum.service.comment;

import com.example.techforum.dto.CommentDto;
import com.example.techforum.model.Comments;

import java.util.List;

public interface ICommentService {
    List<CommentDto> findAllCommentByBlogId(Integer id);
    Comments save(CommentDto commentBlog);
    void delete(Integer id);
    int getCommentCount(Integer blogId);

}
