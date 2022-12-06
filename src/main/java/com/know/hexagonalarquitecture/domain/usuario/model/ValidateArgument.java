package com.know.hexagonalarquitecture.domain.usuario.model;

import com.know.hexagonalarquitecture.domain.usuario.exception.UserMandatoryException;

public class ValidateArgument {

    public static final String USER_NO_EXISTS = "Usuario no existe";

    public static void validateMandatory(Object object, String message){

            if(object==null || object.toString().isEmpty()){
                throw new UserMandatoryException(USER_NO_EXISTS);
            }
        }
}
