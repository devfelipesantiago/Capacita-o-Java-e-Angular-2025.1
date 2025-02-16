package com.br.minsait.services.exceptions;

public class ContactNotFoundException extends NotFoundException {
  public ContactNotFoundException() {
    super("Contact not found");
  }
}
