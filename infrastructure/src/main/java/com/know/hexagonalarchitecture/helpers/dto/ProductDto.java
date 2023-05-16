package com.know.hexagonalarchitecture.helpers.dto;

public class ProductDto {

    private Long idProduct;
    private String name;
    private double price;
    private Long idUser;

    public ProductDto(){}


    public ProductDto(Long idProduct,String name,double price, Long idUser){
        this.idProduct=idProduct;
        this.name=name;
        this.price=price;
        this.idUser=idUser;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
