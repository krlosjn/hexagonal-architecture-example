package com.know.hexagonalarchitecture.product.exception;

public class ProductRepeatException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public ProductRepeatException(String message){
        super(message);
    }

}
