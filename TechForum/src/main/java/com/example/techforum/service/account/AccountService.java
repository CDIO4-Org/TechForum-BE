package com.example.techforum.service.account;

import com.example.techforum.dto.AccountEditStatus;
import com.example.techforum.dto.AccountListDto;
import com.example.techforum.dto.BlogDto;
import com.example.techforum.model.Account;
import com.example.techforum.model.Blogs;
import com.example.techforum.model.Role;
import com.example.techforum.model.Users;
import com.example.techforum.repository.IRoleRepo;
import com.example.techforum.repository.IUserRepo;
import com.example.techforum.request.RegisterForm;
import com.example.techforum.service.mailsender.DisableAccount;
import com.example.techforum.service.mailsender.EmailRegister;
import com.example.techforum.service.mailsender.EnableAccount;
import com.example.techforum.service.role.IRoleService;
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    private DisableAccount disableAccount;

    @Autowired
    private EnableAccount enableAccount;

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

    @Override
    public Page<AccountListDto> getAccountList(Pageable pageable) {
        Page<Account>accountListDtos = accountRepo.findAll(pageable);
        return  accountListDtos.map(account -> new AccountListDto(account));
    }

    @Override
    public void editStatusAccount(int id, AccountEditStatus accountEditStatus) throws MessagingException {
        accountRepo.updateStatus(id, accountEditStatus.getStatus());

        String email = accountRepo.findEmailByAccountId(accountEditStatus.getId());

        if (accountEditStatus.getStatus()) {
            enableAccount.sendEmailEnableAccount(email, accountEditStatus.getAccountName());
        } else {
            disableAccount.sendEmailDisableAccount(email, accountEditStatus.getAccountName());
        }
    }



}
