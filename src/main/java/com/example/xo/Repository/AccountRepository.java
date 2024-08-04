package com.example.xo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.xo.Model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    
}
