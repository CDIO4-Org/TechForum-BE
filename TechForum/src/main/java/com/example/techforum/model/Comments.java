package com.example.techforum.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime date;
    @Column(columnDefinition = "varchar(255)")
    private String content;
    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blogs blog;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public Comments() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
