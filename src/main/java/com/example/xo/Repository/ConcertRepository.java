package com.example.xo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.xo.Model.Concert;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
    
}
