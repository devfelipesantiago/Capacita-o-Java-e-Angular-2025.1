package com.br.minsait.controllers.dtos;

import com.br.minsait.models.entities.Person;

public record PersonDto(int id, String name, String directMail) {

  public static PersonDto toDirectMailDto(Person person) {
    return new PersonDto(
        person.getId(),
        person.getName(),
        person.getAddress() + " - CEP: " + person.getZipCode() + " - " + person.getCity() + "/"
            + person.getState());
  }
}
