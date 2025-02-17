package com.br.minsait.controllers.dtos;

import com.br.minsait.models.entities.Contact;
import com.br.minsait.models.entities.ContactType;
import com.br.minsait.models.entities.Person;

public record ContactDto(ContactType contactType, String contact, int personId) {

  public static Contact toEntity(ContactDto contactDto, Person person) {
    return new Contact(contactDto.contactType, contactDto.contact, person);
  }
}

