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

import com.br.minsait.controllers.dtos.PersonDto;
import com.br.minsait.models.entities.Person;
import com.br.minsait.services.PersonService;
import com.br.minsait.services.exceptions.PersonNotFoundException;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/pessoas")
public class PersonController {

  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping
  @Operation(summary = "Create a new Person")
  @ResponseStatus(HttpStatus.CREATED)
  public Person createPerson(@RequestBody Person person) {
    return personService.createPerson(person);
  }

  @GetMapping("/maladireta/{id}")
  @Operation(summary = "Get Person for Direct Mail")
  @ResponseStatus(HttpStatus.OK)
  public PersonDto directMail(@PathVariable int id) throws PersonNotFoundException {
    return PersonDto.toDirectMailDto(personService.getPersonById(id));
  }

  @GetMapping
  @Operation(summary = "Get all People")
  @ResponseStatus(HttpStatus.OK)
  public List<Person> getAllPersons() {
    return personService.getAllPerson();
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update a Person")
  @ResponseStatus(HttpStatus.OK)
  public Person updatePersonById(@PathVariable int id, @RequestBody Person personData)
      throws PersonNotFoundException {
    return personService.updatePersonById(id, personData);
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete a Person by ID")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public String deletePerson(@PathVariable int id) {
    return personService.deletePersonById(id);
  }
}
