package com.example.techforum.service.likes;

import com.example.techforum.model.Blogs;
import com.example.techforum.model.Likes;
import com.example.techforum.repository.IBlogRepo;
import com.example.techforum.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.techforum.repository.ILikesRepo;

import java.util.List;
import java.util.Optional;

@Service
public class LikesService implements ILikesService{
    @Autowired
    private ILikesRepo likesRepo;
    @Autowired
    private IBlogRepo blogRepo;
    @Autowired
    private IUserRepo userRepo;

    @Override
    public List<Likes> findAll(Integer id) {
        return likesRepo.findAllByUserId(id);
    }

    @Override
    public String toggleLike(Integer blogId, Integer userId) {
        Optional<Likes> existingLike = likesRepo.findByBlogIdAndUserId(blogId, userId);
        if (blogRepo.findById(blogId).isEmpty()){
            return "blog ko ton tai";
        }
        if (userRepo.findById(userId).isEmpty()) {
            return "user ko ton tai";
        }

        if (existingLike.isPresent()) {
            // Nếu đã like -> Unlike
            likesRepo.delete(existingLike.get());
            return "Unlike successful";
        } else {
            // Nếu chưa like -> Thêm like
            Likes newLike = new Likes();
            newLike.setBlog(blogRepo.findById(blogId).get()); // Cần tạo constructor trong Entity Post
            newLike.setUser(userRepo.findById(userId).get()); // Cần tạo constructor trong Entity User
            likesRepo.save(newLike);
            return "Like successful";
        }
    }

    @Override
    public int getLikeCount(Integer blogId) {
        if (blogRepo.findById(blogId).isEmpty()){
            throw new IllegalArgumentException( "blog ko ton tai");
        }
        return likesRepo.countByBlogId(blogId);
    }

    @Override
    public Boolean isBlogLikedByUser(Integer blogId, Integer userId) {
        if (blogId == null || userId == null) {
            throw new IllegalArgumentException("Blog ID and User ID must not be null");
        }
        return likesRepo.findByBlogIdAndUserId(blogId, userId).isPresent();
    }


}
