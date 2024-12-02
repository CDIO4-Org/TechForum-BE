package com.example.techforum.service.cloudinary;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ICloudinaryService {
    String uploadFile(MultipartFile file) throws IOException;
}
