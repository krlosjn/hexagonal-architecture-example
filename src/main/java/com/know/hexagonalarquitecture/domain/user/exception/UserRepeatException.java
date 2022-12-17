package com.know.hexagonalarquitecture.domain.user.exception;

public class UserRepeatException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public UserRepeatException(String message){
        super(message);
    }
}
