package com.know.hexagonalarchitecture.user.exception;

public class DocumentInvalidException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public DocumentInvalidException(String message){
        super(message);
    }
}