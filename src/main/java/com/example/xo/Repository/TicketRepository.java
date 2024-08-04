package com.example.xo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.xo.Model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    
}
