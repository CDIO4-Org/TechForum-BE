package com.example.techforum.repository;

import com.example.techforum.dto.AccountListDto;
import com.example.techforum.dto.ImageDto;
import com.example.techforum.model.Account;
import com.example.techforum.model.Blogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface IAccountRepo extends JpaRepository<Account, Integer> {
//    @Modifying
//    @Query(value = "select a from account as a where a.account_name = :accountName",
//            countQuery = "select a from account as a where a.account_name = :accountName", nativeQuery = true)
    Account findAccountByAccountName(String accountName);
    Boolean existsByAccountName(String username);

    @Modifying
    @Query(value = "update Account a set a.status = :status where a.id = :id",nativeQuery = true)
    void updateStatus(@Param("id") Integer id, @Param("status") boolean status);

    @Query(value = "select email from Users where account_id = ?1",nativeQuery = true)
    String findEmailByAccountId(Integer account);

    Page<Account> findByStatus(Boolean status, Pageable pageable);

}
