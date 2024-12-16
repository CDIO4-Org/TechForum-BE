package com.example.techforum.service.account;

import com.example.techforum.model.Account;
import com.example.techforum.model.Role;
import com.example.techforum.model.Users;
import com.example.techforum.repository.IRoleRepo;
import com.example.techforum.repository.IUserRepo;
import com.example.techforum.request.RegisterForm;
import com.example.techforum.service.mailsender.EmailRegister;
import com.example.techforum.service.role.IRoleService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.techforum.repository.IAccountRepo;

import java.util.Set;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepo accountRepo;

    @Autowired
    private IUserRepo userRepo;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IRoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailRegister emailRegister;

    @Override
    public Boolean existsByAccountName(String accountName) {
        return accountRepo.existsByAccountName(accountName);
    }

    @Override
    public void addNewAccount(RegisterForm account) throws MessagingException {
        String defautAva = "https://scr.vn/wp-content/uploads/2020/07/Avatar-Facebook-trắng.jpg";
        Set<Role> roles = roleRepo.findByRoleName("USER");
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        Account newAccount = new Account(roles, account.getPassword(), account.getAccountName());
        accountRepo.save(newAccount);
        Account accountFind = accountRepo.findAccountByAccountName(account.getAccountName());
        Users newUser= new Users(account.getEmail(), accountFind, defautAva);
        userRepo.save(newUser);
        emailRegister.sendEmailRegister(account.getEmail(), account.getAccountName());
    }


}
