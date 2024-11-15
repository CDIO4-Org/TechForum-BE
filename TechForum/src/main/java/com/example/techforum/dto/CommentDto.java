package com.example.techforum.dto;

import com.example.techforum.model.Blogs;
import com.example.techforum.model.Users;

import java.time.LocalDateTime;

public class CommentDto {
    private LocalDateTime date;
    private String content;
    private Blogs blog;
    private Users user;
    public CommentDto() {}



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
