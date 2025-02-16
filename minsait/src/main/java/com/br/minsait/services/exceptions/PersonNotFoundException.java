package com.br.minsait.services.exceptions;

public class PersonNotFoundException extends NotFoundException {
  public PersonNotFoundException() {
    super("Person not found");
  }
}
