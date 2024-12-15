package com.example.techforum.dto;

import com.example.techforum.model.Blogs;
import com.example.techforum.model.Users;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class ReportDto {
    @NotBlank(message = "Content cannot be empty")
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDate reportDate;
    private Users user;
    private Blogs blog;
    public ReportDto() {}

    public ReportDto(String content, LocalDate reportDate, Users user, Blogs blog) {
        this.content = content;
        this.reportDate = reportDate;
        this.user = user;
        this.blog = blog;
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
