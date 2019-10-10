package com.javaexample.javaapi;

import javax.persistence.*;

@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Contact contact;
    private String number;
    private String type;

    public Phone() {}

    public Phone(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
