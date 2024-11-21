package com.example.techforum.service.role;

import com.example.techforum.model.Role;

import java.util.List;
import java.util.Set;

public interface IRoleService {
    Set<Role> getRolesByName(String name);
}
