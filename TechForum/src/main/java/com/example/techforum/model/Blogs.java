package com.example.techforum.model;

import com.example.techforum.dto.BlogDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Blogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDateTime beginDate;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    @Column(columnDefinition = "BIT")
    @ColumnDefault("0")
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories category;


    public Blogs() {
    }
    @PrePersist
    protected void beginDate() {
        this.beginDate = LocalDateTime.now(); // Gán thời gian khi tạo mới
    }
    public Blogs(BlogDto blog) {
        this.title = blog.getTitle();
        this.content = blog.getContent();
        this.category = blog.getCategory();
        this.user = blog.getUser();
        this.status = false;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
