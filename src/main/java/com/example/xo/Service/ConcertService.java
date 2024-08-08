package com.example.xo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.xo.Model.Concert;
import com.example.xo.Model.Ticket;
import com.example.xo.Repository.ConcertRepository;
import com.example.xo.Repository.TicketRepository;
import com.example.xo.exception.CustomException.ConcertNotFoundException;

@Service
public class ConcertService {

    @Autowired
    private ConcertRepository concertRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public List<Concert> getAllConcerts() {
        return concertRepository.findAll();
    }

    public Concert createConcert(Concert concert) {
        if (concert.getTitle() == null || concert.getEventDate() == null) {
            throw new IllegalArgumentException("Concert title and date cant be null.");
        }
        return concertRepository.save(concert);
    }

    public Concert getConcertById(Long id) {
        return concertRepository.findById(id)
            .orElseThrow(() -> new ConcertNotFoundException("No concert found with id " + id));
    }

    public void deleteConcert(Long id) {
        Concert concert = concertRepository.findById(id)
            .orElseThrow(() -> new ConcertNotFoundException("Concert not found with id " + id));
        concertRepository.delete(concert);
    }

    public void createTickets(Long concertid, int amount) {
        Concert concert = concertRepository.findById(concertid)
            .orElseThrow(() -> new ConcertNotFoundException("Concert not found with id " + concertid));
        for(int i = 0; i < amount; i++) {
            Ticket newticket = new Ticket();
            newticket.setConcert(concert);
            newticket.setOnSale(true);
            ticketRepository.save(newticket);
        }
    }
}
