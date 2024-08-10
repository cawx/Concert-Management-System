package com.example.xo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.xo.Model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findTopByConcertIdAndAccountIsNull(Long concertid);
    List<Ticket> findByAccountId(Long userid);
}
