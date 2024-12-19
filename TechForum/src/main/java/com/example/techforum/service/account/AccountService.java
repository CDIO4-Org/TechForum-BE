package com.example.techforum.service.account;

import com.example.techforum.model.Account;
import com.example.techforum.model.Reports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.techforum.repository.IAccountRepo;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepo accountRepo;

    @Override
    public Page<Account> findByAccount(Pageable pageable) {
        Page<Account> accounts = accountRepo.findByAccount(pageable);
        return accounts;
    }
}
