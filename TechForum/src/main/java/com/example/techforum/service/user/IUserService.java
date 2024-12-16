package com.example.techforum.service.user;

import com.example.techforum.dto.UserDto;

import java.io.IOException;

public interface IUserService {
    Boolean existsByEmail(String email);
    UserDto findByAccountName(String accountName);
    void updateUser(Integer id, UserDto userDto) throws IOException;
}
