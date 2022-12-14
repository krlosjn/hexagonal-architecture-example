package com.know.hexagonalarquitecture.domain.user.model;

import static com.know.hexagonalarquitecture.domain.user.model.ValidateArgument.validateMandatory;

public class UserPerson {

    public static final String NAME_IT_CANTBE_EMPTY = "El nombre no puede ir vacío";
    public static final String LASTNAME_IT_CANTBE_EMPTY = "El apellido no puede ir vacío";
    public static final String DNI_IT_CANTBE_EMPTY = "identificación no puede ir vacío";
    private Long id;

    private String name;

    private String lastName;

    private String dniUser;

    public UserPerson(Long id, String name, String lastName, String dniUser){
        validateMandatory(name, NAME_IT_CANTBE_EMPTY);
        validateMandatory(lastName, LASTNAME_IT_CANTBE_EMPTY);
        validateMandatory(dniUser, DNI_IT_CANTBE_EMPTY);
        this.id=id;
        this.name=name;
        this.lastName=lastName;
        this.dniUser=dniUser;
    }


    public Long getId() {
        return id;
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

}
