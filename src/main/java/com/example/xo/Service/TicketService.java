package com.example.xo.Service;

import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.xo.Model.Account;
import com.example.xo.Model.Ticket;
import com.example.xo.Repository.AccountRepository;
import com.example.xo.Repository.TicketRepository;
import com.example.xo.exception.CustomException.TicketNotFoundException;

@Service
public class TicketService {
    
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
            .orElseThrow(() -> new TicketNotFoundException("Ticket not found with id " + id));
    }

    public void deleteTicket(Long id) {
        Ticket ticket = ticketRepository.findById(id)
            .orElseThrow(() -> new TicketNotFoundException("Ticket not found with id " + id));
        ticketRepository.delete(ticket);
    }

    public void buyTicket(Long userid) throws AccountNotFoundException {
        Optional<Account> acc = accountRepository.findById(userid);
        acc.orElseThrow(() -> new AccountNotFoundException("Account not found"));
    }

}
