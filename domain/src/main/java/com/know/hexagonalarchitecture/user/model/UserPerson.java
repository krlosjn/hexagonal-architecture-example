package com.know.hexagonalarchitecture.user.model;

import com.know.hexagonalarchitecture.product.model.Product;

import java.util.List;

import static com.know.hexagonalarchitecture.utils.ValidateArgument.validateMandatory;
import static com.know.hexagonalarchitecture.utils.ValidateArgument.validateStringDocumentNumber;

public class UserPerson {


    private static final String NAME_IT_CANTBE_EMPTY = "El nombre no puede ir vacío";
    private static final String LASTNAME_IT_CANTBE_EMPTY = "El apellido no puede ir vacío";
    private static final String DNI_IT_CANTBE_EMPTY = "identificación no puede ir vacío";
    private static final String INVALID_DOCUMENT = "Documento inválido";
    private Long idUser;

    private String name;

    private String lastName;

    private String dniUser;

    private List<Product> products;

    public UserPerson(Long id, String name, String lastName, String dniUser,List<Product> products){
        validateMandatory(name, NAME_IT_CANTBE_EMPTY);
        validateMandatory(lastName, LASTNAME_IT_CANTBE_EMPTY);
        validateMandatory(dniUser, DNI_IT_CANTBE_EMPTY);
        validateStringDocumentNumber(dniUser, INVALID_DOCUMENT);
        this.idUser =id;
        this.name=name;
        this.lastName=lastName;
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
    public String getDniUser() {
        return dniUser;
    }
    public List<Product> getProducts(){return  products;}

}
