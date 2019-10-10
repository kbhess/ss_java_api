package com.javaexample.javaapi;

import javax.persistence.*;


@Entity
public class Address {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address() {}

    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }
}
