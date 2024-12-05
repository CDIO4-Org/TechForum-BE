package com.example.techforum.repository;

import com.example.techforum.dto.BlogDto;
import com.example.techforum.model.Likes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILikesRepo extends CrudRepository<Likes, Long> {
    Optional<Likes> findByBlogIdAndUserId(Long blogId, Long userId);
    int countByBlogId(Long postId);
    Page<Likes> findAllByUserId(Long userId,Pageable pageable);

}
