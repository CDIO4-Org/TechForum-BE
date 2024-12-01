package com.example.techforum.service.views;

import com.example.techforum.model.Likes;
import com.example.techforum.model.Views;
import com.example.techforum.repository.IBlogRepo;
import com.example.techforum.repository.IUserRepo;
import com.example.techforum.repository.IViewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.View;
import java.util.Optional;

@Service
public class ViewsService implements IViewsService{
    @Autowired
    private IViewsRepo viewsRepo;
    @Autowired
    private IBlogRepo blogRepo;
    @Autowired
    private IUserRepo userRepo;

    @Override
    public String toggleView(Long blogId, Long userId) {
        Optional<Views> existingView = viewsRepo.findByBlogIdAndUserId(blogId, userId);
        if (blogRepo.findById(blogId).isEmpty()){
            return "blog ko ton tai";
        }
        if (userRepo.findById(userId).isEmpty()) {
            return "user ko ton tai";
        }

        if (existingView.isPresent()) {
            return "is present";
        } else {
            Views newView = new Views();
            newView.setBlog(blogRepo.findById(blogId).get()); // Cần tạo constructor trong Entity Post
            newView.setUser(userRepo.findById(userId).get()); // Cần tạo constructor trong Entity User
            viewsRepo.save(newView);
            return "save view successful";
        }
    }

    @Override
    public int getViewCount(Long blogId) {
        if (blogRepo.findById(blogId).isEmpty()){
            throw new IllegalArgumentException( "blog ko ton tai");
        }
        return viewsRepo.countByBlogId(blogId);
    }
}
