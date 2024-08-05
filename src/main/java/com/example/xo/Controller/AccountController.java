package com.example.xo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.xo.Model.Account;
import com.example.xo.Repository.AccountRepository;

@Controller
public class AccountController {
    
    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/account")
    Account newUser(@RequestBody Account newAccount) {
        return accountRepository.save(newAccount);
    }
    
}
