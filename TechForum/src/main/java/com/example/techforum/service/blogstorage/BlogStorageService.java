package com.example.techforum.service.blogstorage;

import com.example.techforum.model.BlogStorage;
import com.example.techforum.model.Likes;
import com.example.techforum.repository.IBlogRepo;
import com.example.techforum.repository.IUserRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.techforum.repository.IBlogStorageRepo;

import java.util.List;
import java.util.Optional;

@Service
public class BlogStorageService implements IBlogStorageService {
    @Autowired
    private IBlogStorageRepo blogStorageRepo;
    @Autowired
    private IBlogRepo blogRepo;
    @Autowired
    private IUserRepo userRepo;

    @Override
    public List<BlogStorage> findAllByUserId(Integer id) {
        return blogStorageRepo.findAllByUserId(id);
    }

    @Override
    public String toggleBookMark(Integer blogId, Integer userId) {
        Optional<BlogStorage> existingLike = blogStorageRepo.findBlogStoragesByBlogIdAndUserId(blogId, userId);
        if (blogRepo.findById(blogId).isEmpty()){
            return "blog ko ton tai";
        }
        if (userRepo.findById(userId).isEmpty()) {
            return "user ko ton tai";
        }

        if (existingLike.isPresent()) {
            blogStorageRepo.delete(existingLike.get());
            return "deleted blog in storage";
        } else {
            BlogStorage newBookMark = new BlogStorage();
            newBookMark.setBlog(blogRepo.findById(blogId).get());
            newBookMark.setUser(userRepo.findById(userId).get());
            blogStorageRepo.save(newBookMark);
            return "add new blog to storage";
        }
    }

    @Override
    public void delete(Integer id) {
        if (blogStorageRepo.existsById(id)){
            blogStorageRepo.deleteById(id);
        }else {
            throw new EntityNotFoundException("Blog not found with id: " + id);
        }
    }

    @Override
    public int getCount(Integer blogId) {
        if (blogRepo.findById(blogId).isEmpty()){
            throw new IllegalArgumentException( "blog ko ton tai");
        }
        return blogStorageRepo.countByBlogId(blogId);
    }

    @Override
    public Boolean isBlogBookMarkedByUser(Integer blogId, Integer userId) {
        if (blogId == null || userId == null) {
            throw new IllegalArgumentException("Blog ID and User ID must not be null");
        }
        return blogStorageRepo.findBlogStoragesByBlogIdAndUserId(blogId, userId).isPresent();
    }
}
