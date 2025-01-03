package com.example.techforum.dto;

import com.example.techforum.model.Blogs;
import com.example.techforum.model.Users;

public class LikesDto {
    private Integer amount;
    private Blogs blog;
    private Users user;

    public LikesDto() {
    }


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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
