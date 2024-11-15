package com.example.techforum.service.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.techforum.repository.IRoleRepo;

@Service
public class RoleService implements IRoleService{
    @Autowired
    private IRoleRepo roleRepo;
}
