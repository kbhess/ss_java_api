package com.javaexample.javaapi;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class ContactResourceAssembler implements ResourceAssembler<Contact, Resource<Contact>> {

    @Override
    public Resource<Contact> toResource(Contact contact) {
        return new Resource<>(contact,
                linkTo(methodOn(ContactController.class).one(contact.getId())).withSelfRel(),
                linkTo(methodOn(ContactController.class).all()).withRel("contacts"));
    }
}
