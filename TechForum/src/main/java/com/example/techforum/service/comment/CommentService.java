package com.example.techforum.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.techforum.repository.ICommentRepo;

@Service
public class CommentService implements ICommentService{
    @Autowired
    private ICommentRepo commentRepo;
}
