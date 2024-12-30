package com.example.demo.exceptions;

public class LoginExistsException extends RuntimeException{
    public LoginExistsException(String login){
        super(String.format("Demo with login %s already exists", login));
    }
}
