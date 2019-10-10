package com.javaexample.javaapi;

public class ContactNotFoundException extends RuntimeException {

    ContactNotFoundException(Long id) {
        super("Cound not find contact with ID " + id);
    }
}
