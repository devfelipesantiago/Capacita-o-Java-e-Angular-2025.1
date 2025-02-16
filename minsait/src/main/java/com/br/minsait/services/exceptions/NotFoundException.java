package com.br.minsait.services.exceptions;

public abstract class NotFoundException extends Exception {
  public NotFoundException(String message) {
    super(message);
  }
}
