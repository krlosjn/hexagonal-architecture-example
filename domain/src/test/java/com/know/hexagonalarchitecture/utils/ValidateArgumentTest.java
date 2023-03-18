package com.know.hexagonalarchitecture.utils;


import com.know.hexagonalarchitecture.product.exception.NumberPriceException;
import com.know.hexagonalarchitecture.user.exception.DocumentInvalidException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.know.hexagonalarchitecture.utils.ValidateArgument.*;


public  class ValidateArgumentTest {
    @Test
    public void testValidObject() {
        Object object = "example";
        String message = "Object cannot be null or empty";
        Assertions.assertDoesNotThrow(() -> validateMandatory(object, message));
    }

    @Test
    public void testNullObject() {
        Object object = null;
        String message = "Object cannot be null or empty";
        Assertions.assertThrows(MandatoryException.class, () -> validateMandatory(object, message));
    }

    @Test
    public void testEmptyObject() {
        Object object = "";
        String message = "Object cannot be null or empty";
        Assertions.assertThrows(MandatoryException.class, () -> validateMandatory(object, message));
    }


    @Test
    public void  ShouldThrowExcepcionMinNumber(){
        String document="12345";
        String message="another message for number document";

        Assertions.assertThrows(DocumentInvalidException.class,()->validateStringDocumentNumber(document,message));
    }

    @Test
    public void  ShouldThrowExcepcionMoreTenNumbers(){
        String document="123456789011";
        String message="another message for number document";

        Assertions.assertThrows(DocumentInvalidException.class,()->validateStringDocumentNumber(document,message));
    }

    @Test
    public void shouldThrowsExceptionWithNegativeNumber(){
        Double sal=-12.0;
        String message="should be positive number";

        Assertions.assertThrows(NumberPriceException.class,()->validatePrice(sal,message));

    }


}