package com.know.hexagonalarchitecture.testDataBuilder;

import com.know.hexagonalarchitecture.product.model.Product;
import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.utils.exception.BusinessException;

import java.util.Collections;
import java.util.List;

public class UserPersonTestDataBuilder {

    private Long idUser;
    private String name;
    private String lastName;
    private String typeDocument;
    private String nmDocument;
    private String dniUser;
    private List<Product> products;


    public UserPersonTestDataBuilder() throws BusinessException {
        this.idUser=1L;
        this.name="Maria";
        this.lastName="Ramirez";
        this.typeDocument="C";
        this.nmDocument="1234567890";
        this.dniUser=typeDocument+nmDocument;
        this.products= Collections.singletonList(new Product(1L, "Ropa", 200.0, 1L));
    }


    public UserPersonTestDataBuilder withIdUser(Long idUser){
        this.idUser=idUser;
        return this;
    }

    public UserPersonTestDataBuilder withName(String name){
        this.name=name;
        return this;
    }

    public UserPersonTestDataBuilder withLastName(String lastName){
        this.lastName=lastName;
        return this;
    }

    public UserPersonTestDataBuilder withTypeDocument(String typeDocument){
        this.typeDocument=typeDocument;
        return this;
    }

    public UserPersonTestDataBuilder withNmDocument(String nmDocument){
        this.nmDocument=nmDocument;
        return this;
    }

    public UserPersonTestDataBuilder withProduct(List<Product> products){
        this.products=products;
        return this;
    }

    public UserPersonTestDataBuilder withDniUser(String dniUser){
        this.dniUser=dniUser;
        return this;
    }

    public UserPerson build() throws BusinessException {
        return new UserPerson(idUser,name,lastName,nmDocument,typeDocument,dniUser,products);
    }
}

