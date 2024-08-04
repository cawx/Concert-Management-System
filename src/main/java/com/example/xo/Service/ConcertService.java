package com.example.xo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.xo.Model.Concert;
import com.example.xo.Repository.ConcertRepository;

@Service
public class ConcertService {

    @Autowired
    private ConcertRepository concertRepository;

    public List<Concert> getAllConcerts() {
        return concertRepository.findAll();
    }
    public Concert createConcert(Concert concert) {
        return concertRepository.save(concert);
    }
    public Concert getConcertById(Long id) {
        return concertRepository.findById(id).orElseThrow(() -> new RuntimeException("No concert found with id " + id));
    }
    public void deleteConcert(Long id) {
        Concert concert = concertRepository.findById(id).orElseThrow(() -> new RuntimeException("Concert not found with id " + id));
        concertRepository.delete(concert);
    }
}
