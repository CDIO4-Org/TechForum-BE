package com.example.techforum.repository;

import com.example.techforum.model.Likes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikesRepo extends CrudRepository<Likes, Integer> {
}
