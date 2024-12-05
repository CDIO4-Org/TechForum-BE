package com.example.techforum.service.blogstorage;

import com.example.techforum.model.BlogStorage;
import com.example.techforum.repository.IBlogRepo;
import com.example.techforum.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.techforum.repository.IBlogStorageRepo;

import java.util.List;

@Service
public class BlogStorageService implements IBlogStorageService {
    @Autowired
    private IBlogStorageRepo blogStorageRepo;
    @Autowired
    private IBlogRepo blogRepo;
    @Autowired
    private IUserRepo userRepo;

    @Override
    public Page<BlogStorage> findAllByUserId(Long id, Pageable pageable) {
        return null;
    }

    @Override
    public BlogStorage save(BlogStorage blogStorage) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public int getCount(Long blogId) {
        return 0;
    }
}
