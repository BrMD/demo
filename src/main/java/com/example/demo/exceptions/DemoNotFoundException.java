package com.example.demo.exceptions;

public class DemoNotFoundException extends RuntimeException{
    public DemoNotFoundException(Long id){
        super(String.format("Demo with id %d, not found", id));
    }
}
