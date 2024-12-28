package com.example.techforum.repository;

import com.example.techforum.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface IAccountRepo extends JpaRepository<Account, Integer> {

    Account findAccountByAccountName(String accountName);
    Boolean existsByAccountName(String username);
}
