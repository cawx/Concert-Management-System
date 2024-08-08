package com.example.xo.Model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Concert {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private LocalDateTime eventDate;
    private int ticketCount;
    /* 
    mappedby is used to specify the owner side of the relationship (the side with foreign keys).
    its used to establish bidirectional relationships between 2 entities. the value is the name of
    the property that owns the relationship.
    */ 
    @OneToMany(mappedBy = "concert") 
    private List<Ticket> tickets;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDateTime getEventDate() {
        return eventDate;
    }
    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }
    public List<Ticket> getTickets() {
        return tickets;
    }
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    public int getTicketCount() {
        return ticketCount;
    }
    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }
}   
