package com.example.techforum.controller;

import com.example.techforum.dto.AccountDto;
import com.example.techforum.service.account.IAccountService;
import com.example.techforum.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IAccountService accountService;


}
