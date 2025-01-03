package com.example.techforum.dto;

import com.example.techforum.model.Blogs;

public class ImageDto {
    private String nameImg;
    private Blogs blog;

    public ImageDto() {
    }

    public ImageDto(Blogs blog) {
        this.blog = blog;
    }

    public ImageDto(String nameImg, Blogs blog) {
        this.nameImg = nameImg;
        this.blog = blog;
    }

    public String getNameImg() {
        return nameImg;
    }

    public void setNameImg(String nameImg) {
        this.nameImg = nameImg;
    }

    public Blogs getBlog() {
        return blog;
    }

    public void setBlog(Blogs blog) {
        this.blog = blog;
    }
}
