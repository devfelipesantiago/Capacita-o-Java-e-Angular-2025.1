package com.br.minsait.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.minsait.models.entities.Person;
import com.br.minsait.models.repositories.PersonRepository;
import com.br.minsait.services.exceptions.PersonNotFoundException;

@Service
public class PersonService {

  private final PersonRepository personRepository;

  @Autowired
  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public Person createPerson(Person person) {
    return personRepository.save(person);
  }

  public List<Person> getAllPerson() {
    return personRepository.findAll();
  }

  public Person getPersonById(int id) throws PersonNotFoundException {
    return personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
  }

  public Person updatePersonById(int id, Person personData) throws PersonNotFoundException {
    Person oldPerson = getPersonById(id);
    oldPerson.setName(personData.getName());
    oldPerson.setAddress(personData.getAddress());
    oldPerson.setCity(personData.getCity());
    oldPerson.setState(personData.getState());
    oldPerson.setZipCode(personData.getZipCode());

    personRepository.save(oldPerson);
    return oldPerson;
  }

  public String deletePersonById(int id) {
    personRepository.deleteById(id);
    return "Successfully deleted";
  }
}
