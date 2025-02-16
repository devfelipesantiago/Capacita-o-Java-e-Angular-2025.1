package com.br.minsait.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.minsait.models.entities.Contact;
import com.br.minsait.services.ContactService;
import com.br.minsait.services.exceptions.ContactNotFoundException;
import com.br.minsait.services.exceptions.PersonNotFoundException;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/contatos")
public class ContactController {

  private final ContactService contactService;

  @Autowired
  public ContactController(ContactService contactService) {
    this.contactService = contactService;
  }

  @PostMapping
  @Operation(summary = "Add a new Contact to a Person")
  @ResponseStatus(HttpStatus.CREATED)
  public Contact createContact(@RequestBody Contact contact)
      throws PersonNotFoundException {
    return contactService.addContact(contact);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get a Contact by ID")
  @ResponseStatus(HttpStatus.OK)
  public Contact findContactById(@PathVariable int id) throws ContactNotFoundException {
    return contactService.findContactById(id);
  }

  @GetMapping("/pessoa/{pessoaId}")
  @Operation(summary = "Get all Contacts of a Person")
  @ResponseStatus(HttpStatus.OK)
  public List<Contact> listByPerson(@PathVariable int pessoaId) {
    return contactService.findContactByPersonId(pessoaId);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update a Contact")
  @ResponseStatus(HttpStatus.OK)
  public Contact updateContact(@PathVariable int id, @RequestBody Contact contact) {
    return contact;
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete a Contact by ID")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public String deleteContact(@PathVariable int id) {
    return contactService.delete(id);
  }

  @GetMapping
  @Operation(summary = "Get all contact")
  @ResponseStatus(HttpStatus.OK)
  public List<Contact> getAllPersons() {
    return contactService.getAllPerson();
  }
}
