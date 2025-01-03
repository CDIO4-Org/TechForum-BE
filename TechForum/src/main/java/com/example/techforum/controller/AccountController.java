package com.example.techforum.controller;


import com.example.techforum.dto.AccountEditStatus;
import com.example.techforum.dto.AccountListDto;
import com.example.techforum.request.LoginForm;
import com.example.techforum.request.RegisterForm;
import com.example.techforum.response.JwtResponse;
import com.example.techforum.response.ResponseMessage;
import com.example.techforum.security.jwt.JwtTokenProvider;
import com.example.techforum.security.userpricipal.UserPrinciple;
import com.example.techforum.service.account.IAccountService;
import com.example.techforum.service.user.IUserService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @Autowired
    private IUserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/account/register")
    public ResponseEntity<?> register(@RequestBody RegisterForm account) throws MessagingException {
        if (accountService.existsByAccountName(account.getAccountName()) || userService.existsByEmail(account.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Tên tài khoản hoặc email đã tồn tại"), HttpStatus.BAD_REQUEST);
        }
        accountService.addNewAccount(account);
        return new ResponseEntity<>(new ResponseMessage("Account was be created"), HttpStatus.CREATED);
    }

    @PostMapping("/account/login")
    public ResponseEntity<?> login(@RequestBody LoginForm account) {
        boolean isAccountLocked = accountService.getStatusAccount(account.getAccountName());
        if (isAccountLocked) {
            return new ResponseEntity<>(new ResponseMessage("Tài khoản đã bị vô hiệu hóa"), HttpStatus.UNAUTHORIZED);
        }
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(account.getAccountName(), account.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtTokenProvider.generateToken(authentication);
            UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
            LocalDateTime time = LocalDateTime.now();
            return new ResponseEntity<>(new JwtResponse(token, userPrinciple.getUsername(), userPrinciple.getAuthorities(), time), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("Tài khoản hoặc mật khẩu không đúng"), HttpStatus.UNAUTHORIZED);
        }

    }

    @GetMapping("/admin/getAllAccount")
    public ResponseEntity<Page<AccountListDto>> getAllAccounts(
            @RequestParam(defaultValue = "0") int page, // Trang bắt đầu, mặc định là 0
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);

        Page<AccountListDto> accountListDtos = accountService.getAccountList(pageable);
        return ResponseEntity.ok(accountListDtos);
    }

    @PutMapping("/admin/updateSatusAccount/{id}")
    public ResponseEntity<String> updateBlog(@PathVariable int id, @RequestBody AccountEditStatus accountEditStatus) throws MessagingException {
        accountService.editStatusAccount(id, accountEditStatus);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/admin/getListStatusActive")
    public ResponseEntity<Page<AccountListDto>> getListStatusActive(
            @RequestParam(defaultValue = "0") int page, // Trang bắt đầu, mặc định là 0
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);

        Page<AccountListDto> accountListDtos = accountService.findByStatus(false, pageable);
        return ResponseEntity.ok(accountListDtos);
    }

    @GetMapping("/admin/getListStatusNonActive")
    public ResponseEntity<Page<AccountListDto>> getListStatusNonActive(
            @RequestParam(defaultValue = "0") int page, // Trang bắt đầu, mặc định là 0
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);

        Page<AccountListDto> accountListDtos = accountService.findByStatus(true, pageable);
        return ResponseEntity.ok(accountListDtos);
    }

}
