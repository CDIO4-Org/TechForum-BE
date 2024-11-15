package com.example.techforum.dto;

import com.example.techforum.model.Blogs;
import com.example.techforum.model.Users;

import java.time.LocalDate;

public class BlogStorageDto {
    private LocalDate date;
    private Blogs blog;
    private Users user;
    public BlogStorageDto() {}



    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
