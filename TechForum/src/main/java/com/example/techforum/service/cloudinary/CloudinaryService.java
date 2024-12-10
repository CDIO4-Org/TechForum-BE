package com.example.techforum.service.cloudinary;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService implements ICloudinaryService {
    @Autowired
    private Cloudinary cloudinary;
    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        Map<String, Object> uploadParams = new HashMap<>();
        // Thêm các tham số cần thiết vào uploadParams nếu cần
//        uploadParams.put("folder", "your-folder-name"); // Ví dụ, nếu bạn muốn chỉ định thư mục

        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), uploadParams);
        return (String) uploadResult.get("secure_url");  // trả về URL của file đã upload
    }
}
