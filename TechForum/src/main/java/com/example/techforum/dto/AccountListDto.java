package com.example.techforum.dto;

import com.example.techforum.model.Account;
import com.example.techforum.model.Blogs;
import com.example.techforum.model.Role;

import java.util.HashSet;
import java.util.Set;

public class AccountListDto {
    private Integer id;
    private String accountName;
    private Boolean status;
    Set<Role> roles = new HashSet<>();


    public AccountListDto(Integer id, String accountName, Boolean status, Set<Role> roles) {
        this.id = id;
        this.accountName = accountName;
        this.status = status;
        this.roles = roles;
    }

    public AccountListDto(Account account) {
        this.id = account.getId();
        this.accountName = account.getAccountName();
        this.status = account.getStatus();
        this.roles = account.getRoles();

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
