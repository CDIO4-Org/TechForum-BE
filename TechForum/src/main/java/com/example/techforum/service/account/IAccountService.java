package com.example.techforum.service.account;


import com.example.techforum.dto.AccountEditStatus;
import com.example.techforum.dto.AccountListDto;

import com.example.techforum.model.Account;
import com.example.techforum.request.RegisterForm;
import jakarta.mail.MessagingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAccountService {
    Boolean existsByAccountName(String accountName);
    void addNewAccount(RegisterForm account) throws MessagingException;
    Page<AccountListDto> getAccountList(Pageable pageable);
    void editStatusAccount(int id, AccountEditStatus accountEditStatus) throws MessagingException;
    Page<AccountListDto> findByStatus(Boolean status, Pageable pageable);
    Boolean getStatusAccount(String accountName);
}
