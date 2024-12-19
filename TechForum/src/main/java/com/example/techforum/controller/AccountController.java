package com.example.techforum.controller;

import com.example.techforum.model.Account;
import com.example.techforum.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @GetMapping("/getPageAccount")
    public ResponseEntity<Page<Account>> getPageAccount(
            @RequestParam(defaultValue = "0") int page, // Trang bắt đầu, mặc định là 0
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "status,asc") String[] sort// Kích thước mỗi trang, mặc định là 10
    ) {
        Sort.Direction direction = Sort.Direction.fromString(sort[1]);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort[0]));

        Page<Account> accounts = accountService.findByAccount(pageable);
        return ResponseEntity.ok(accounts);
    }
}
