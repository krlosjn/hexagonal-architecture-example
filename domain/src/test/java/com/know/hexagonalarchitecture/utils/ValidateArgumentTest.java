package com.know.hexagonalarchitecture.utils;


import com.know.hexagonalarchitecture.utils.exception.BusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.know.hexagonalarchitecture.utils.ValidateArgument.*;


public  class ValidateArgumentTest {
    @Test
    public void testValidObject() {
        Object object = "example";
        String message = "Object cannot be null or empty";
        Assertions.assertDoesNotThrow(() -> validateMandatory(object));
    }

    @Test
    public void testNullObject() {
        Object object = null;
        String message = "Object cannot be null or empty";
        Assertions.assertThrows(BusinessException.class, () -> validateMandatory(object));
    }

    @Test
    public void testEmptyObject() {
        Object object = "";
        String message = "Object cannot be null or empty";
        Assertions.assertThrows(BusinessException.class, () -> validateMandatory(object));
    }


    @Test
    public void  ShouldThrowExcepcionMinNumber(){
        String document="12345";
        String message="another message for number document";

        Assertions.assertThrows(BusinessException.class,()->validateStringDocumentNumber(document));
    }

    @Test
    public void  ShouldThrowExcepcionMoreTenNumbers(){
        String document="123456789011";
        String message="another message for number document";

        Assertions.assertThrows(BusinessException.class,()->validateStringDocumentNumber(document));
    }

    @Test
    public void shouldThrowsExceptionWithNegativeNumber(){
        Double sal=-12.0;

        Assertions.assertThrows(BusinessException.class,()->validatePrice(sal));

    }


}