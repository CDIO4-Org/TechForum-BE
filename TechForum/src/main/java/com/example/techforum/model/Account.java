package com.example.techforum.model;

import com.example.techforum.dto.AccountEditStatus;
import com.example.techforum.dto.AccountListDto;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String accountName;
    private String password;
    @Column(columnDefinition = "bit")
    @ColumnDefault("0")
    private Boolean status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_role",joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles = new HashSet<>();

    public Account() {
    }

    public Account(Set<Role> roles, String password, String accountName) {
        this.roles = roles;
        this.password = password;
        this.accountName = accountName;
        this.status = false;
    }

    public Account(AccountListDto account){
        this.id = account.getId();
        this.accountName = account.getAccountName();
        this.status = account.getStatus();
        this.roles = account.getRoles();
    }

    public Account(AccountEditStatus account){
        this.id = account.getId();
        this.status = account.getStatus();
        this.accountName = account.getAccountName();
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
