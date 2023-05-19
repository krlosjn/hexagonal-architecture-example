package com.know.hexagonalarchitecture.testDataBuilder;

import com.know.hexagonalarchitecture.product.model.Product;

public class ProductTestDataBuilder {
    private Long idProduct;
    private String name;
    private double price;
    private Long idUser;

    public ProductTestDataBuilder() {
        this.idProduct = 1L;
        this.name = "Shirt";
        this.price = 200.0;
        this.idUser = 1L;
    }

    public ProductTestDataBuilder withIdProduct(Long idProduct){
        this.idProduct=idProduct;
        return this;
    }

    public ProductTestDataBuilder withName(String name){
        this.name=name;
        return this;
    }

    public ProductTestDataBuilder witthPrice(Double price){
        this.price=price;
        return this;
    }

    public ProductTestDataBuilder withIdeUser(Long idUser){
        this.idUser=idUser;
        return this;
    }

    public Product build(){
        return new Product(idProduct,name,price,idUser);
    }
}
