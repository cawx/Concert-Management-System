package com.example.xo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.xo.Model.Concert;
import com.example.xo.Service.ConcertService;

@RestController
@RequestMapping("/api/concerts")
public class ConcertController {
    @Autowired
    private ConcertService concertService;

    @GetMapping
    public List<Concert> getAllConcerts() {
        return concertService.getAllConcerts();
    }

    @Secured("ADMIN")
    @PostMapping
    public Concert createConcert(@RequestBody Concert concert) {
        return concertService.createConcert(concert);
    }

    @Secured("ADMIN")
    @DeleteMapping("/{id}")
    public void deleteConcert(@PathVariable Long id) {
        concertService.deleteConcert(id);
    }

    @Secured("ADMIN")
    @PostMapping("/{id}/tickets")
    public void createTickets(@PathVariable Long id, @RequestParam int amount) {
        concertService.createTickets(id, amount);
    }
}
