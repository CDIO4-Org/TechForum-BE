package com.example.techforum.repository;

import com.example.techforum.dto.BlogDto;
import com.example.techforum.model.Likes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ILikesRepo extends CrudRepository<Likes, Integer> {
    Optional<Likes> findByBlogIdAndUserId(Integer blogId, Integer userId);
    int countByBlogId(Integer postId);
    
    List<Likes> findAllByUserId(Integer userId);

}
