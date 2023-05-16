package com.know.hexagonalarchitecture.utils;

import com.know.hexagonalarchitecture.utils.exception.BusinessException;
import com.know.hexagonalarchitecture.utils.exception.BusinessExceptionMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateArgument {


    public static void validateMandatory(Object object) throws BusinessException {
            if(object==null || object.toString().isEmpty()){
                throw new BusinessException(BusinessExceptionMessage.OBJECTINVALID.toString());
            }
    }

    public static String validateStringDocumentNumber(String document) throws BusinessException {
        String regexNumber="^[0-9]{10}$";
      if(!document.matches(regexNumber)){
          throw  new BusinessException(BusinessExceptionMessage.NUMBERDOCUMENTINVALID.toString());
      }
      return document;
    }

    public static void validatePrice(double value) throws BusinessException {

        String numeroStr = Double.toString(value);

        String regex = "^(?:\\d{1,4}(?:\\.\\d{1,2})?|99999(?:\\.0{1,2})?)$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(numeroStr);

        if(!matcher.matches()){
            throw new BusinessException(BusinessExceptionMessage.NUMBERPRICEEXCEPTION.toString());
        }
    }

    public static String  validateTypeDocument(String type) throws BusinessException {
        String regex = "^[a-zA-Z]{1}$";
        if(!type.matches(regex)){
            throw  new BusinessException(BusinessExceptionMessage.TYPEDOCUMENTINVALID.name()+ "  " + type);
        }
        return type;
    }
    

}
