package com.example.techforum.request;

public class LoginForm {
    private String accountName;
    private String password;

    public LoginForm(String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
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
}

