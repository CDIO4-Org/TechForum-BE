package com.example.techforum.repository;

import com.example.techforum.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IRoleRepo extends JpaRepository<Role, Integer> {
    Set<Role> findByRoleName(String name);
}
