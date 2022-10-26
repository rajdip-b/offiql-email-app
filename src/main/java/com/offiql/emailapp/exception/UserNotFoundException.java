package com.offiql.emailapp.exception;

public class UserNotFoundException extends Exception{

    public UserNotFoundException() {
        super("User not found!");
    }

}
