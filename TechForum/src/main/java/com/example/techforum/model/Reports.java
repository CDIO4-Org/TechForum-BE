package com.example.techforum.model;

import com.example.techforum.dto.ReportDto;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
public class Reports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(150)")
    private String content;
    private LocalDate reportDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blogs blog;
    @ColumnDefault("0")
    private Boolean status;

    public Reports(ReportDto reportDTO) {
        this.content = reportDTO.getContent();
        this.reportDate = reportDTO.getReportDate();
        this.user = reportDTO.getUser();
        this.blog = reportDTO.getBlog();
    }

    public Reports(String content, LocalDate reportDate, Users user, Blogs blog) {

    }

    public Reports() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
