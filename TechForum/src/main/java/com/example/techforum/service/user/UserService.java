package com.example.techforum.service.user;

import com.example.techforum.dto.UserDto;
import com.example.techforum.dto.UserEditDto;
import com.example.techforum.model.Users;
import com.example.techforum.repository.IUserRepo;
import com.example.techforum.service.cloudinary.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepo userRepo;
    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public Boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }

    @Override
    public UserDto findByAccountName(String accountName) {
        Users newUser = userRepo.findByAccountName(accountName);
        UserDto user = new UserDto(newUser.getId(),newUser.getFirstName(), newUser.getAvatar(), newUser.getLastName(), newUser.getEmail(), newUser.getGender(),
                newUser.getPhoneNumber(), newUser.getBirthDate(), newUser.getAddress(), newUser.getAccount().getId());
        return user;
    }

    @Override
    public void updateUser(Integer id, UserEditDto userEditDto) throws IOException {
        String urlName = cloudinaryService.uploadFile(userEditDto.getAvatar());
        System.out.println(urlName);
        Users user = userRepo.findById(id).get();
        user.setFirstName(userEditDto.getFirstName());
        user.setLastName(userEditDto.getLastName());
        user.setEmail(userEditDto.getEmail());
        user.setGender(userEditDto.getGender());
        user.setPhoneNumber(userEditDto.getPhoneNumber());
        user.setBirthDate(userEditDto.getBirthDate());
        user.setAddress(userEditDto.getAddress());
        user.setAvatar(urlName);
        userRepo.save(user);
    }
}
