package com.example.xo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.xo.Model.Ticket;
import com.example.xo.Repository.AccountRepository;
import com.example.xo.Repository.TicketRepository;
import com.example.xo.exception.CustomException.AccountNotFoundException;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getUserTickets(Long userid) throws AccountNotFoundException {
        List<Ticket> tickets = ticketRepository.findByAccountId(userid);
        if(!accountRepository.existsById(userid)) {
            throw new AccountNotFoundException("Something went wrong...");
        }
        if(tickets.isEmpty()) {
            throw new AccountNotFoundException("You have no tickets...");
        }
        return tickets;
    }

}
