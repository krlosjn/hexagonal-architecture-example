package com.know.hexagonalarchitecture.helpers.dto;

import com.know.hexagonalarchitecture.product.model.Product;

import java.util.List;

public class UserPersonDto {

    private Long idUser;
    private String name;
    private String lastName;
    private String numberDocument;
    private String typeDocument;
    private List<Product> products;

    public UserPersonDto(){

    }

    public UserPersonDto(Long idUser, String name, String lastName, String numberDocument, String typeDocument, List<Product> products) {
        this.idUser = idUser;
        this.name = name;
        this.lastName = lastName;
        this.numberDocument = numberDocument;
        this.typeDocument = typeDocument;
        this.products = products;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(String numberDocument) {
        this.numberDocument = numberDocument;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
