package com.javaexample.javaapi;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade=CascadeType.ALL)
    private Name name;
    @OneToOne(cascade=CascadeType.ALL)
    private Address address;
    private String email;
    @OneToMany(targetEntity=Phone.class, mappedBy="contact", fetch=FetchType.LAZY)
    private List<Phone> phone;

    public Contact() {}

    public Contact (Name name, Address address, List<Phone> phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        setPhoneContacts();
    }

    private void setPhoneContacts() {
        for (Phone ph : phone) {
            ph.setContact(this);
        }
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }
}
