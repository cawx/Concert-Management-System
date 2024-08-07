package com.example.xo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.xo.Model.Account;
import com.example.xo.Repository.AccountRepository;

@Service
public class AccountDetailService implements UserDetailsService {

    @Autowired
    private AccountRepository repository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = repository.findByUsername(username);
        if(account.isPresent()){
            Account acc = account.get();
            return User.builder()
                       .username(acc.getUsername())
                       .password(acc.getPassword())
                       .authorities(acc.getRole())
                       .build();
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
