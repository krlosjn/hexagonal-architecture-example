package com.know.hexagonalarchitecture.domain.product.exception;

public class NumberPriceException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public NumberPriceException(String message){
        super(message);
    }

}
