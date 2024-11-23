package com.example.techforum.service.likes;

public interface ILikesService {
    String toggleLike(Long blogId, Long userId);
    int getLikeCount(Long blogId);
    Boolean isBlogLikedByUser(Long blogId, Long userId);
}
