package com.example.xo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.xo.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
