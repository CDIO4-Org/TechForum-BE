package com.example.techforum.service.account;

import com.example.techforum.request.RegisterForm;
import jakarta.mail.MessagingException;

public interface IAccountService {
    Boolean existsByAccountName(String accountName);
    void addNewAccount(RegisterForm account) throws MessagingException;
}
