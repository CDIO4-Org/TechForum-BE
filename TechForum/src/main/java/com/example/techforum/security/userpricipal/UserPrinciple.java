package com.example.techforum.security.userpricipal;

import com.example.techforum.dto.AccountDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {
    private Integer id;
    @JsonIgnore
    private String accountName;
    @JsonIgnore
    private String password;

    public UserPrinciple(){}
    public UserPrinciple(AccountDto accountDto) {}

    public Collection<? extends GrantedAuthority> authorities;
    public UserPrinciple(Integer id, String accountName, String password, Collection<? extends GrantedAuthority> authorities) {
        super();
        this.id = id;
        this.accountName = accountName;
        this.password = password;
        this.authorities = authorities;
    }
    public static UserPrinciple create(AccountDto accountDto) {
        List<GrantedAuthority> authorities = accountDto.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
        return new UserPrinciple(
                accountDto.getId(), // User principle co name
                accountDto.getAccountName(),
                accountDto.getPassword(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.accountName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
