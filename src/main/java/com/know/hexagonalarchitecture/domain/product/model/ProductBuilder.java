package com.know.hexagonalarchitecture.domain.product.model;

public class ProductBuilder {

    private Long id;
    private String name;
    private double price;

    public ProductBuilder(){}


    public ProductBuilder withId(Long id){
        this.id=id;
        return this;
    }

    public ProductBuilder withName(String name){
        this.name=name;
        return this;
    }

    public ProductBuilder withPrice(double price){
        this.price=price;
        return this;
    }

    public Product build(){
        return new Product(id,name,price);
    };
}
