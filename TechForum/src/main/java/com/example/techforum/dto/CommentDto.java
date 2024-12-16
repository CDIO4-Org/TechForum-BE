package com.example.techforum.dto;

import com.example.techforum.model.Blogs;
import com.example.techforum.model.Comments;
import com.example.techforum.model.Users;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CommentDto {
    private Integer id;
    private LocalDateTime date;
    @NotBlank(message = "Not Blank")
    @NotNull(message = "not null")
    private String content;
    @NotNull(message = "not null")
    private Blogs blog;
    @NotNull(message = "not null")
    private Users user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public CommentDto(Comments comments) {
        this.id = comments.getId();
        this.date = comments.getDate();
        this.content = comments.getContent();
        this.blog = comments.getBlog();
        this.user = comments.getUser();
    }

    public CommentDto() {
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Blogs getBlog() {
        return blog;
    }

    public void setBlog(Blogs blog) {
        this.blog = blog;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
