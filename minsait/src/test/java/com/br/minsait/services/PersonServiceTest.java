package com.br.minsait.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import com.br.minsait.models.entities.Person;
import com.br.minsait.models.repositories.PersonRepository;
import com.br.minsait.services.exceptions.PersonNotFoundException;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class PersonServiceTest {

  @Autowired
  PersonService personService;

  @MockBean
  PersonRepository personRepository;

  @Test
  void createPerson() {
    Person person = new Person();
    person.setName("Jonh Doe");
    person.setAddress("123 Main St");
    person.setZipCode("12345-678");
    person.setCity("São Paulo");
    person.setState("SP");

    Person personToReturn = new Person();
    personToReturn.setId(123);
    personToReturn.setName(person.getName());
    personToReturn.setAddress(person.getAddress());
    personToReturn.setZipCode(person.getZipCode());
    personToReturn.setCity(person.getCity());
    personToReturn.setState(person.getState());

    Mockito.when(personRepository.save(any())).thenReturn(personToReturn);

    Person savedPerson = personService.createPerson(person);

    Mockito.verify(personRepository).save(any());

    assertEquals(123, savedPerson.getId());
    assertEquals(person.getName(), savedPerson.getName());
    assertEquals(person.getAddress(), savedPerson.getAddress());
    assertEquals(person.getZipCode(), savedPerson.getZipCode());
    assertEquals(person.getCity(), savedPerson.getCity());
    assertEquals(person.getState(), savedPerson.getState());

  }

  @Test
  public void personNotFound() {
    Mockito.when(personRepository.findById(any()))
        .thenReturn(Optional.empty());

    assertThrows(PersonNotFoundException.class, () -> personService.getPersonById(456));

    Mockito.verify(personRepository).findById(eq(456));
  }

  @Test
  void getAllPerson() {
  }

  @Test
  void getPersonById() {
  }

  @Test
  void updatePersonById() {
  }

  @Test
  void deletePersonById() {
  }
}