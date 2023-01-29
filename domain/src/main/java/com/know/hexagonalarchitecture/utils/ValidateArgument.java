package com.know.hexagonalarchitecture.utils;

import com.know.hexagonalarchitecture.product.exception.NumberPriceException;
import com.know.hexagonalarchitecture.user.exception.DocumentInvalidException;

public class ValidateArgument {


    public static void validateMandatory(Object object, String message){
            if(object==null || object.toString().isEmpty()){
                throw new MandatoryException(message);
            }
    }

    public static void validateStringDocumentNumber(String document, String message){
      if(document.length()<10 || document.length()>10){
          throw  new DocumentInvalidException(message);
      }
    }

    public static void validatePrice(double value, String message){
        if(value<=0){
            throw new NumberPriceException(message);
        }
    }
}
