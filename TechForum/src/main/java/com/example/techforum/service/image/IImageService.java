package com.example.techforum.service.image;

import com.example.techforum.dto.BlogDto;
import com.example.techforum.dto.ImageDto;
import com.example.techforum.model.Images;

import java.util.List;

public interface IImageService {

    void createBlogImage(Images blogImg);

    List<Images> findAllImages();

    List<ImageDto> getImagesByBlogId(Long blogId);
}
