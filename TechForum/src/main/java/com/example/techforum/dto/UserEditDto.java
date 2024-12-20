package com.example.techforum.dto;

import com.example.techforum.model.Account;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class UserEditDto {
    private MultipartFile avatar;
    private String firstName;
    private String lastName;
    private String email;
    private Integer gender;
    private String phoneNumber;
    private LocalDate birthDate;
    private String address;

    public UserEditDto(MultipartFile avatar, String firstName, String lastName, String email, Integer gender, String phoneNumber, LocalDate birthDate, String address) {
        this.avatar = avatar;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.address = address;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
