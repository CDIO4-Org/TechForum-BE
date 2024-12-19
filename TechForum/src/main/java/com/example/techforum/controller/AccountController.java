package com.example.techforum.controller;

import com.example.techforum.dto.AccountDto;
import com.example.techforum.dto.AccountEditStatus;
import com.example.techforum.dto.AccountListDto;
import com.example.techforum.dto.BlogDto;
import com.example.techforum.request.LoginForm;
import com.example.techforum.request.RegisterForm;
import com.example.techforum.response.JwtResponse;
import com.example.techforum.response.ResponseMessage;
import com.example.techforum.security.jwt.JwtTokenProvider;
import com.example.techforum.security.userpricipal.UserPrinciple;
import com.example.techforum.service.account.IAccountService;
import com.example.techforum.service.user.IUserService;
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        if(accountService.existsByAccountName(account.getAccountName()) || userService.existsByEmail(account.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Email or UserName already exists"),HttpStatus.OK);
        }
        accountService.addNewAccount(account);
        return new ResponseEntity<>(new ResponseMessage("Account was be created"), HttpStatus.CREATED);
    }

    @PostMapping("/account/login")
    public ResponseEntity<?> login(@RequestBody LoginForm account) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getAccountName(), account.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        LocalDateTime time = LocalDateTime.now();
        return new ResponseEntity<>(new JwtResponse(token,userPrinciple.getUsername(),userPrinciple.getAuthorities(),time), HttpStatus.OK);
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
}
