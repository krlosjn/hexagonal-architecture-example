package com.know.hexagonalarchitecture.product.model;


import com.know.hexagonalarchitecture.utils.ValidateArgument;

public class Product {

    public static final String PRODUCT_NAME_CANTBE_EMPTY = "El nombre del producto no puede estar vacío";
    public static final String CANTBE_ZERO_OR_NEGATIVE = "No puede ser cero o negativo";
    private Long idProduct;

    private String name;

    private double price;

    private Long idUser;


    public Product(Long id, String name, double price,Long idUser) {
        ValidateArgument.validateMandatory(name, PRODUCT_NAME_CANTBE_EMPTY);
        ValidateArgument.validatePrice(price, CANTBE_ZERO_OR_NEGATIVE);
        this.idProduct = id;
        this.name = name;
        this.price = price;
        this.idUser=idUser;
    }


    public Long getIdProduct() {
        return idProduct;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public Long getIdUser(){
        return idUser;
    }

}
