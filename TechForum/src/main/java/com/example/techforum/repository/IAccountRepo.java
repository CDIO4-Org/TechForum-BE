package com.example.techforum.repository;

import com.example.techforum.model.Account;
import com.example.techforum.model.Reports;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepo extends JpaRepository<Account, Integer> {
    @Query(value = "select * from account", nativeQuery = true)
    Page<Account> findByAccount(Pageable pageable);
}
