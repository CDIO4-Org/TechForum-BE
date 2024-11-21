package com.example.techforum.security.userpricipal;


import com.example.techforum.dto.AccountDto;
import com.example.techforum.model.Account;
import com.example.techforum.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IAccountRepo iAccountRepo;
    @Override
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
        Account account = iAccountRepo.findAccountByAccountName(accountName);
        AccountDto accountDto = new AccountDto(account.getId(), account.getAccountName(), account.getPassword(), account.getRoles());
        if (accountDto == null) {
            throw new UsernameNotFoundException("Not found account with username " + accountName);
        }
        return UserPrinciple.create(accountDto);
    }
}
