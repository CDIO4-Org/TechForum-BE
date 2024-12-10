package com.example.techforum.request;

public class RegisterForm {
    private String accountName;
    private String password;
    private String email;

    public RegisterForm(String accountName, String password, String email) {
        this.accountName = accountName;
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
