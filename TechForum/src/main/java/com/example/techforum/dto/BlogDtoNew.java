package com.example.techforum.dto;

import com.example.techforum.model.Categories;
import com.example.techforum.model.Users;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class BlogDtoNew {
    //    @NotBlank(message = "Title cannot be empty")
//    @Size(min = 3, max = 255, message = "Title must be between 3 and 255 characters")
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime beginDate;
    //    @NotBlank(message = "Content cannot be empty")
//    @Size(min = 3, message = "Content must be at least 3 characters")
    private String content;
    private Boolean status;
    //    @NotNull(message = "User cannot be null")
    private Integer user;
    //    @NotNull(message = "Category cannot be null")
    private Integer category;

    public BlogDtoNew(String title, LocalDateTime beginDate, String content, Boolean status, Integer user, Integer category) {
        this.title = title;
        this.beginDate = beginDate;
        this.content = content;
        this.status = status;
        this.user = user;
        this.category = category;
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

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
}
