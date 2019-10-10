package com.javaexample.javaapi;

import javax.persistence.*;

@Entity
public class Number {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String number;
    private String type;

    public Number() {}

    public Number(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }
}
