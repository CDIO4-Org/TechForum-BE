package com.example.techforum.repository;

import com.example.techforum.model.BlogStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogStorageRepo extends JpaRepository<BlogStorage, Long> {
}
