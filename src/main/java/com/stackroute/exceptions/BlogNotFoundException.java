package com.stackroute.exceptions;

public class BlogNotFoundException extends Exception{
  String message = "Blog Not Found";

  public BlogNotFoundException(){}

  public BlogNotFoundException(String message){
    this.message = message;
  }

  public String getMessage(){
    return message;
  }
}
