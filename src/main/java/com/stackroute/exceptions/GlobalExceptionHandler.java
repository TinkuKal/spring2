package com.stackroute.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = BlogNotFoundException.class)
  public ResponseEntity<String> blogNotFound(){
    return new ResponseEntity<String>("Blog Not Found", HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = BlogAlreadyExistsException.class)
  public ResponseEntity<String> blogAlreadyExist(){
    return new ResponseEntity<String>("Blog Already Exist", HttpStatus.CONFLICT);
  }

}
