package com.example.techforum.service.likes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.techforum.repository.ILikesRepo;

@Service
public class LikesService implements ILikesService{
    @Autowired
    private ILikesRepo likesRepo;
}
