package com.example.techforum.service.user;

import com.example.techforum.dto.UserDto;
import com.example.techforum.dto.UserEditDto;

import java.io.IOException;

public interface IUserService {
    Boolean existsByEmail(String email);
    UserDto findByAccountName(String accountName);
    void updateUser(Integer id, UserEditDto userEditDto) throws IOException;
}
