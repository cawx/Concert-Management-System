package com.example.xo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.xo.Service.TicketService;

import org.springframework.web.bind.annotation.PostMapping;


@RequestMapping("/api/tickets")
@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/buy")
    public String buyTicket(@RequestParam Long userid, @RequestParam Long concertid) {
        try {
            ticketService.buyTicket(userid, concertid);
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
        
        return "ticket";
    }
    
}
