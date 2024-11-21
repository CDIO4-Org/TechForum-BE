package com.example.techforum.service.role;

import com.example.techforum.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.techforum.repository.IRoleRepo;

import java.util.List;
import java.util.Set;

@Service
public class RoleService implements IRoleService{
    @Autowired
    private IRoleRepo roleRepo;

    @Override
    public Set<Role> getRolesByName(String name) {
        return roleRepo.findByRoleName(name);
    }
}
