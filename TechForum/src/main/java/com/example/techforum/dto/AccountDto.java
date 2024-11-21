package com.example.techforum.dto;

import com.example.techforum.model.Role;

import java.util.HashSet;
import java.util.Set;

public class AccountDto {
    private Integer id;
    private String accountName;
    private String password;
    private Boolean status;
    Set<Role> roles = new HashSet<>();

    public AccountDto() {}

    public AccountDto( Integer id,String accountName, String password) {
        this.id = id;
        this.accountName = accountName;
        this.password = password;
    }

    public AccountDto(Integer id, String accountName, String password, Set<Role> roles) {
        this.id = id;
        this.accountName = accountName;
        this.password = password;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
