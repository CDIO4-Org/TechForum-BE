package com.example.techforum.service.likes;

import com.example.techforum.model.BlogStorage;
import com.example.techforum.model.Likes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILikesService {
    Page<Likes> findAll(Integer gid,Pageable pageable);
    String toggleLike(Integer blogId, Integer userId);
    int getLikeCount(Integer blogId);
    Boolean isBlogLikedByUser(Integer blogId, Integer userId);
}
