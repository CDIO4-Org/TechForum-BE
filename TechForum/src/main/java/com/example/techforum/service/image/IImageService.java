package com.example.techforum.service.image;

import com.example.techforum.model.Images;

import java.util.List;

public interface IImageService {

    void createBlogImage(Images blogImg);

    List<Images> findAllImages();
}
