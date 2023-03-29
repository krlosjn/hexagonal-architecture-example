package com.know.hexagonalarchitecture.product.model;

public class Product {

    private Long idProduct;
    private String name;
    private double price;
    private Long idUser;

    public Product(Long id, String name, double price,Long idUser)  {
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
