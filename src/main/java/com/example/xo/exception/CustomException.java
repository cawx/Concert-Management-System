package com.example.xo.exception;

public class CustomException {
    
    // concert cant be found exception
    public static class ConcertNotFoundException extends RuntimeException {
        public ConcertNotFoundException(String message) {
            super(message);
        }     
    }
    // ticket cant be found exception
    public static class TicketNotFoundException extends RuntimeException {
        public TicketNotFoundException(String message) {
            super(message);
        }     
    }
    // account cant be found exception
    public static class AccountNotFoundException extends RuntimeException {
        public AccountNotFoundException(String message) {
            super(message);
        }     
    }
}
