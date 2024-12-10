package com.example.techforum.service.user;

import com.example.techforum.dto.UserDto;
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
    public UserDto findByAccountId(Integer id) {
        Users newUser = userRepo.findByAccountId(id);
        UserDto user = new UserDto( newUser.getFirstName(), newUser.getAvatar(), newUser.getLastName(), newUser.getEmail(), newUser.getGender(),
                newUser.getPhoneNumber(), newUser.getBirthDate(), newUser.getAddress());
        return user;
    }

    @Override
    public void updateUser(Integer id, UserDto userDto) throws IOException {
        String urlName = cloudinaryService.uploadFile(userDto.getAvatar());
        System.out.println(urlName);
        Users user = userRepo.findById(id).get();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setGender(userDto.getGender());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setBirthDate(userDto.getBirthDate());
        user.setAddress(userDto.getAddress());
        user.setAvatar(urlName);
        userRepo.save(user);
    }
}
