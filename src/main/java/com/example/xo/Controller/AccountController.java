package com.example.xo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.xo.Repository.AccountRepository;
import com.example.xo.Service.AccountService;
import com.example.xo.Model.Account;
import com.example.xo.Model.Ticket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
public class AccountController {
    
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<String> registerAccount( @RequestBody Account account) {

        if(accountRepository.findByUsername(account.getUsername()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username is taken");
        }

        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setRole("ROLE_USER");
        accountRepository.save(account);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered");
    }
  
    @GetMapping("/getTickets")
    public ResponseEntity<List<Ticket>> getTickets(@RequestParam Long userid) {
        List<Ticket> tickets = accountService.getUserTickets(userid);
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }
    
    
}
