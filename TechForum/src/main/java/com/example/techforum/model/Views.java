package com.example.techforum.model;

import jakarta.persistence.*;

@Entity
public class Views {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blogs blog;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public Views() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
