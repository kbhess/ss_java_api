package com.javaexample.javaapi;

import javax.persistence.*;

@Entity
public class Name {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String first;
    private String middle;
    private String last;

    public Name() {}

    public Name (String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public String getMiddle() {
        return middle;
    }

    public String getLast() {
        return last;
    }
}
