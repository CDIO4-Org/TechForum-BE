package com.example.techforum.dto;

public class RoleDto {
    private String roleName;

    public RoleDto(String roleName) {
        this.roleName = roleName;
    }



    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
