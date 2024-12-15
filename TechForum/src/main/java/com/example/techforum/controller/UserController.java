package com.example.techforum.controller;

import com.example.techforum.dto.AccountDto;
import com.example.techforum.dto.UserDto;
import com.example.techforum.response.ResponseMessage;
import com.example.techforum.service.account.IAccountService;
import com.example.techforum.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IAccountService accountService;

    @GetMapping("/profile/{id}")
    public ResponseEntity<UserDto> getProfile(@PathVariable("id") Integer id) {
        if(userService.findByAccountId(id)==null){
            return new ResponseEntity(new ResponseMessage("Find not found user"), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(userService.findByAccountId(id));
    }

    @PutMapping(value = "/profile/update/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable("id")Integer id, @ModelAttribute UserDto userDto) throws IOException {
        userService.updateUser(id, userDto);
        return new ResponseEntity<>(new ResponseMessage("Update success"), HttpStatus.OK);
    }

}
