package com.br.minsait.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.minsait.controllers.dtos.ContactDto;
import com.br.minsait.models.entities.Contact;
import com.br.minsait.models.entities.Person;
import com.br.minsait.models.repositories.ContactRepository;
import com.br.minsait.services.exceptions.ContactNotFoundException;
import com.br.minsait.services.exceptions.PersonNotFoundException;

@Service
public class ContactService {

  private final ContactRepository contactRepository;
  private final PersonService personService;

  @Autowired
  public ContactService(ContactRepository contactRepository,
      PersonService personService) {
    this.contactRepository = contactRepository;
    this.personService = personService;
  }

  public Contact addContact(ContactDto contactDto) throws PersonNotFoundException {
    Person person = personService.getPersonById(contactDto.personId());

    Contact contact = ContactDto.toEntity(contactDto, person);
    return contactRepository.save(contact);
  }

  public Contact findContactById(int id) throws ContactNotFoundException {
    return contactRepository.findById(id).orElseThrow(ContactNotFoundException::new);
  }

  public List<Contact> findContactsByPersonId(int pessoaId) {
    return contactRepository.findContactByPerson_Id(pessoaId);
  }

  public String delete(int id) {
    contactRepository.deleteById(id);
    return "Successfully deleted";
  }

  public List<Contact> getAllPerson() {
    return contactRepository.findAll();
  }
}
