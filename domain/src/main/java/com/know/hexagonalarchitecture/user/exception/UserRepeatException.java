package com.know.hexagonalarchitecture.user.exception;

public class UserRepeatException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public UserRepeatException(String message){
        super(message);
    }
}
