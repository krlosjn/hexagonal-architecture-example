package com.know.hexagonalarchitecture.domain.utils;

public class MandatoryException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MandatoryException(String message){
        super(message);
    }

}
