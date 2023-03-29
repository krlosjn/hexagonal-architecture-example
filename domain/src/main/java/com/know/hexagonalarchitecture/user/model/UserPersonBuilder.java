package com.know.hexagonalarchitecture.user.model;

import com.know.hexagonalarchitecture.product.model.Product;

import java.util.List;

public class UserPersonBuilder {

    private Long idUser;
    private String name;
    private String lastName;
    private String typeDocument;
    private String nmDocument;
    private String dniUser;
    private List<Product> products;

    public UserPersonBuilder(){}

    public UserPersonBuilder withId(Long id){
        this.idUser =id;
        return this;
    }

    public UserPersonBuilder withName(String name){
        this.name=name;
        return this;
    }


    public UserPersonBuilder withLastName(String lastName){
        this.lastName=lastName;
        return this;
    }


    public UserPersonBuilder withTypeDocument(String typeDocument){
        this.typeDocument =typeDocument;
        return this;
    }

    public UserPersonBuilder withNmDocument(String nmDocument){
        this.nmDocument=nmDocument;
        return this;
    }

    public UserPersonBuilder withProducts(List<Product> products){
        this.products=products;
        return  this;
    }

    public UserPersonBuilder withDniUser(String dniUser){
        this.dniUser=dniUser;
        return this;
    }

    public UserPerson build() {
        return new UserPerson(idUser,name,lastName, typeDocument, nmDocument, dniUser,products);
    }
}
