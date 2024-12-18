package com.example.techforum.repository;

import com.example.techforum.model.Account;
import com.example.techforum.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<Users, Integer> {
    Boolean existsByEmail(String email);

    @Query(value = "select u.id, u.avatar, u.first_name, u.last_name, u.phone_number, u.birth_date, u.email, u.address, u.gender, u.account_id from users as u inner join account as a on u.account_id = a.id where a.account_name = :accountName", nativeQuery = true)
    Users findByAccountName(@Param("accountName") String accountName);


}
