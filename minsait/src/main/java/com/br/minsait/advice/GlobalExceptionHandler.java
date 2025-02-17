package com.br.minsait.advice;

import com.br.minsait.services.exceptions.ContactNotFoundException;
import com.br.minsait.services.exceptions.NotFoundException;
import com.br.minsait.services.exceptions.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({
      PersonNotFoundException.class,
      ContactNotFoundException.class
  })
  public ResponseEntity<String> handleNotFound(NotFoundException e) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(e.getMessage());
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<String> handleRuntimeException(RuntimeException exception) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(exception.getMessage());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(Exception exception) {
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(exception.getMessage());
  }

  @ExceptionHandler(Throwable.class)
  public ResponseEntity<String> handleThrowable(Throwable exception) {
    return ResponseEntity
        .status(HttpStatus.BAD_GATEWAY)
        .body(exception.getMessage());
  }
}
