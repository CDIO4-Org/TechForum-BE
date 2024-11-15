package com.example.techforum.dto;

import com.example.techforum.model.Blogs;
import com.example.techforum.model.Users;

import java.time.LocalDate;

public class ReportDto {
    private String content;
    private LocalDate reportDate;
    private Users user;
    private Blogs blog;
    public ReportDto() {}



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
