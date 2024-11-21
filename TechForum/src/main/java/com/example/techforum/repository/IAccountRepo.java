package com.example.techforum.repository;

import com.example.techforum.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface IAccountRepo extends JpaRepository<Account, Integer> {
//    @Modifying
//    @Query(value = "select a from account as a where a.account_name = :accountName",
//            countQuery = "select a from account as a where a.account_name = :accountName", nativeQuery = true)
    Account findAccountByAccountName(String accountName);
    Boolean existsByAccountName(String username);


}
