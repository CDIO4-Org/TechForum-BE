package com.example.techforum.repository;

import com.example.techforum.model.Views;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IViewsRepo extends JpaRepository<Views, Integer> {
}
