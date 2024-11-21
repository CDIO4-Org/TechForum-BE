package com.example.techforum.service.image;

import com.example.techforum.dto.BlogDto;
import com.example.techforum.dto.ImageDto;
import com.example.techforum.model.Blogs;
import com.example.techforum.model.Images;
import com.example.techforum.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageProcessingService {
    @Autowired
    private ImageService imageService;
    @Autowired
    private IBlogService blogService;

    public void createBlogImage(ImageDto imageDto) {
        Images images = new Images();
        Blogs blogs = blogService.findById(blogService.getLastInsert());
        images.setBlog(blogs);
        images.setNameImg(imageDto.getNameImg());
        imageService.createBlogImage(images);
    }
}
