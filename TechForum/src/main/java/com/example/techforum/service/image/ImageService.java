package com.example.techforum.service.image;

import com.example.techforum.model.Images;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.techforum.repository.IImageRepo;

import java.util.List;

@Service
public class ImageService implements IImageService{
    @Autowired
    private IImageRepo iImageRepo;

    @Override
    public void createBlogImage(Images blogImg) {
        iImageRepo.createImgBlog(blogImg.getNameImg(), blogImg.getBlog().getId());
    }

    @Override
    public List<Images> findAllImages() {
        return iImageRepo.findAll();
    }

}
