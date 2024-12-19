package com.example.techforum.service.account;

import com.example.techforum.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAccountService {
    Page<Account> findByAccount(Pageable pageable);
}
