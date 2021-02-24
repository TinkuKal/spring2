package com.stackroute.exceptions;

public class BlogAlreadyExistsException extends Exception{
  public String message = "Blog Aready Exist";

  public BlogAlreadyExistsException(){

  }

  public BlogAlreadyExistsException(String message){
    this.message = message;
  }

  public String getMessage(){
    return message;
  }
}
