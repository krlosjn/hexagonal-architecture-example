package com.know.hexagonalarchitecture.user.model;

import com.know.hexagonalarchitecture.product.model.Product;
import java.util.List;


public class UserPerson {
    
    private Long idUser;
    private String name;
    private String lastName;
    private String numberDocument;
    private String typeDocument;
    private String dniUser;

    private List<Product> products;

    public UserPerson(Long id, String name, String lastName, String nmDocument,String typeDocument,String dniUser,List<Product> products){
        this.idUser =id;
        this.name=name;
        this.lastName=lastName;
        this.numberDocument =nmDocument;
        this.typeDocument=typeDocument;
        this.dniUser=dniUser;
        this.products=products;
    }

    public Long getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumberDocument() {
        return numberDocument;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public String getDniUser() {
        return dniUser;
    }

    public List<Product> getProducts() {
        return products;
    }
}
