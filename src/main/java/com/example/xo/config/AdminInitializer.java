package com.example.xo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.xo.Model.Account;
import com.example.xo.Repository.AccountRepository;

@Component
public class AdminInitializer implements CommandLineRunner {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // create admin acc if no admins are present in the db
        if(accountRepository.findByRole("ROLE_ADMIN").isEmpty()) {
            Account admin = new Account();
            admin.setUsername("admin"); // yes i know its bad ill fix it later
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setRole("ROLE_ADMIN");
            accountRepository.save(admin);
            System.out.println("Admin account created.");
        }
    }
    
}
