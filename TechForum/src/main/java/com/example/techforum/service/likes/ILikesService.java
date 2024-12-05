package com.example.techforum.service.likes;

import com.example.techforum.model.BlogStorage;
import com.example.techforum.model.Likes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILikesService {
    Page<Likes> findAll(Long gid,Pageable pageable);
    String toggleLike(Long blogId, Long userId);
    int getLikeCount(Long blogId);
    Boolean isBlogLikedByUser(Long blogId, Long userId);
}
