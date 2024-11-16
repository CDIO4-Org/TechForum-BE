package com.example.techforum.dto;

import com.example.techforum.model.Blogs;
import com.example.techforum.model.Categories;
import com.example.techforum.model.Users;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class BlogDto {
    @NotBlank(message = "Title cannot be empty")
    @Size(min = 3, max = 255, message = "Title must be between 3 and 255 characters")
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime beginDate;
    @NotBlank(message = "Content cannot be empty")
    @Size(min = 3, message = "Content must be at least 3 characters")
    private String content;
    private Boolean status;
    @NotNull(message = "User cannot be null")
    private Users user;
    @NotNull(message = "Category cannot be null")
    private Categories category;

    public BlogDto() {
    }

    public BlogDto(Blogs blog) {
        this.title = blog.getTitle();
        this.content = blog.getContent();
        this.category = blog.getCategory();
        this.user = blog.getUser();
        this.status = blog.getStatus();
        this.beginDate = blog.getBeginDate();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDateTime beginDate) {
        this.beginDate = beginDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }
}
