package com.example.techforum.controller;

import com.example.techforum.dto.BlogDto;
import com.example.techforum.dto.CommentDto;
import com.example.techforum.model.Blogs;
import com.example.techforum.model.Comments;
import com.example.techforum.service.comment.ICommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class CommentController {
    @Autowired
    private ICommentService commentService;
    @GetMapping("/findAllByIdBlog")
    public ResponseEntity<List<CommentDto>> findAllByIdBlog(@RequestParam Long id) {
        try {
            List<CommentDto> cmt = commentService.findAllCommentByBlogId(id);
            return ResponseEntity.ok(cmt); // HTTP 200
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // HTTP 500
        }
    }


    @PostMapping("/addNewComment")
    public ResponseEntity<Comments> addNewComment(@RequestBody @Valid CommentDto cmt) {
        Comments savedBlog = commentService.save(cmt);
        return new ResponseEntity<>(savedBlog, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteComment")
    public ResponseEntity<String> deleteComment(@RequestParam Long id){
        commentService.delete(id);
        return new ResponseEntity<>("Xoa thanh cong",HttpStatus.OK);
    }
    @GetMapping("/countComment")
    public int getLikeCount(@RequestParam Long blogId) {
        return commentService.getCommentCount(blogId);
    }
}
