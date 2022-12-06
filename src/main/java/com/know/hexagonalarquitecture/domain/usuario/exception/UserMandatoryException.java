package com.know.hexagonalarquitecture.domain.usuario.exception;

public class UserMandatoryException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserMandatoryException(String message){
        super(message);
    }

}
