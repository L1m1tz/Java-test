package com.andrew.demo;

public class UserNotFoundException extends RuntimeException{

    UserNotFoundException(Long id){
        super("Could not find User" + id);
    }
}
