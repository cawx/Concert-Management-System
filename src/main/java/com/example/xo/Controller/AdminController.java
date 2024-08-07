package com.example.xo.Controller;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.xo.Model.Account;
import com.example.xo.Repository.AccountRepository;

@RestController
public class AdminController {
    
    @Autowired
    private AccountRepository accountRepository;

    private static final String ROLE_USER = "USER";
    private static final String ROLE_ADMIN = "ADMIN";

    @Secured("ROLE_ADMIN")
    @PutMapping("/admin/changerole")
    public Account changeRole(@RequestBody Account account) throws Exception {
        String newrole = account.getRole();
        if(newrole == null || (!newrole.equals(ROLE_USER) && !newrole.equals(ROLE_ADMIN))) {
            throw new RoleNotFoundException("Invalid role "+newrole);
        }
        Account acc = accountRepository.findById(account.getId()).orElseThrow(() -> new Exception("User not found"));
        acc.setRole("ROLE_"+account.getRole());
        return accountRepository.save(acc);
    }
}
