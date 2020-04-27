package com.etoak.execption;

public class UserLoginException extends RuntimeException{
    public UserLoginException(String message){
        super(message);
    }
}
