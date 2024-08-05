package com.example.xo.Service;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.xo.Model.Account;
import com.example.xo.Repository.AccountRepository;

public class AccountDetailService implements UserDetailsService {

    @Autowired
    private AccountRepository repository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = repository.findByUsername(username);
        if(account.isPresent()){
            var accountObj = account.get();
            return User.builder()
                .username(accountObj.getUsername())
                .password("$2a$12$5fTNjx3IiOepVhqCXY1Oi.qZrrSFcgZMHvufUpZd1JWnq3Nkspfqa")
                .roles("ADMIN", "USER")
                .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
    
}
