package com.know.hexagonalarchitecture.domain.product.model;

import static com.know.hexagonalarchitecture.domain.utils.ValidateArgument.validateMandatory;
import static com.know.hexagonalarchitecture.domain.utils.ValidateArgument.validatePrice;

public class Product {

    public static final String PRODUCT_NAME_CANTBE_EMPTY = "El nombre del producto no puede estar vacío";
    public static final String CANTBE_ZERO_OR_NEGATIVE = "No puede ser cero o negativo";
    private Long id;

    private String name;

    private double price;


    public Product(Long id, String name, double price) {
        validateMandatory(name, PRODUCT_NAME_CANTBE_EMPTY);
        validatePrice(price, CANTBE_ZERO_OR_NEGATIVE);
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
