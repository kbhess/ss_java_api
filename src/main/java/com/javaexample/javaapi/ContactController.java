package com.javaexample.javaapi;

import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    private final ContactRepository repository;
    private final ContactResourceAssembler assembler;

    public ContactController(ContactRepository repository, ContactResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/contacts")
    public List<Contact> all() {
        return repository.findAll();
    }

    @PostMapping("/contacts")
    public Contact newContact(@RequestBody Contact newContact) {
        return repository.save(newContact);
    }

    @GetMapping("/contacts/{id}")
    public Resource<Contact> one(@PathVariable Long id) {
        // attempt to get contact
        Contact contact = repository.findById(id).orElseThrow(() -> new ContactNotFoundException(id));
        // return resource
        return assembler.toResource(contact);
    }

    @PutMapping("/contacts/{id}")
    public Contact replaceContact(@RequestBody Contact newContact, @PathVariable Long id) {
        return repository.findById(id).map(contact -> {
            contact.setName(newContact.getName());
            contact.setAddress(newContact.getAddress());
            contact.setPhone(newContact.getPhone());
            contact.setEmail(newContact.getEmail());
            return repository.save(newContact);
        }).orElseGet(() -> {
            newContact.setId(id);
            return repository.save(newContact);
        });
    }

    @DeleteMapping("/contacts/{id}")
    public void deleteContact(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
