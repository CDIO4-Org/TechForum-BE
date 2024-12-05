package com.example.techforum.service.comment;

import com.example.techforum.dto.CommentDto;
import com.example.techforum.model.Comments;
import com.example.techforum.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.techforum.repository.ICommentRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService implements ICommentService{
    @Autowired
    private ICommentRepo commentRepo;
    @Autowired
    private IBlogRepo blogRepo;

    @Override
    public List<CommentDto> findAllCommentByBlogId(Long id) {
        List<Comments> cmt = commentRepo.findAllByBlogId(id);
        return cmt.stream()
                .map(comments -> new CommentDto(comments))
                .collect(Collectors.toList());
    }

    @Override
    public Comments save(CommentDto commentBlog) {
        return commentRepo.save(dtoToObject(commentBlog));
    }

    @Override
    public void delete(Long id) {
        commentRepo.deleteById(id);
    }

    @Override
    public int getCommentCount(Long blogId) {
        if (blogRepo.findById(blogId).isEmpty()){
            throw new IllegalArgumentException( "blog ko ton tai");
        }
        return commentRepo.countByBlogId(blogId);
    }

    public Comments dtoToObject(CommentDto commentDto){
        return new Comments(commentDto);
    }
}
