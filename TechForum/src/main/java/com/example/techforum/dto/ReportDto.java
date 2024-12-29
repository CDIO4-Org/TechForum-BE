package com.example.techforum.dto;

import com.example.techforum.model.Blogs;
import com.example.techforum.model.Users;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class ReportDto {
    private Integer id;
    @NotBlank(message = "Content cannot be empty")
    private String content;
    private LocalDate reportDate = LocalDate.now();
    private Users user;
    private Blogs blog;
    private Boolean status;
    public ReportDto() {}

    public ReportDto(String content, LocalDate reportDate, Users user, Blogs blog, Boolean status) {
        this.content = content;
        this.reportDate = reportDate;
        this.user = user;
        this.blog = blog;
        this.status = false;
    }

    public ReportDto(Integer id, String content, LocalDate reportDate, Users user, Blogs blog, Boolean status) {
        this.id = id;
        this.content = content;
        this.reportDate = reportDate;
        this.user = user;
        this.blog = blog;
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Blogs getBlog() {
        return blog;
    }

    public void setBlog(Blogs blog) {
        this.blog = blog;
    }
}
