package com.example.techforum.dto;

import com.example.techforum.model.Account;

public class AccountEditStatus {
    private Integer id;
    private Boolean status;
    private String accountName;

    public AccountEditStatus(Integer id, Boolean status, String accountName) {
        this.id = id;
        this.status = status;
        this.accountName = accountName;
    }

    public AccountEditStatus(Account account) {
        this.id = account.getId();
        this.accountName = account.getAccountName();
        this.status = account.getStatus();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
