package com.know.hexagonalarchitecture.utils;


import com.know.hexagonalarchitecture.utils.exception.BusinessException;
import org.junit.Test;


import static com.know.hexagonalarchitecture.utils.ValidateArgument.*;
import static org.junit.Assert.assertThrows;


public  class ValidateArgumentTest {


    @Test
    public void testNullObject() {
        Object object = null;
        String message = "Object cannot be null or empty";
        assertThrows(BusinessException.class, () -> validateMandatory(object));
    }

    @Test
    public void testEmptyObject() {
        Object object = "";
        String message = "Object cannot be null or empty";
        assertThrows(BusinessException.class, () -> validateMandatory(object));
    }


    @Test
    public void  ShouldThrowExcepcionMinNumber(){
        String document="12345";
        String message="another message for number document";

        assertThrows(BusinessException.class,()->validateStringDocumentNumber(document));
    }

    @Test
    public void  ShouldThrowExceptionMoreTenNumbers(){
        String document="123456789011";
        String message="another message for number document";

        assertThrows(BusinessException.class,()->validateStringDocumentNumber(document));
    }

    @Test
    public void shouldThrowsExceptionWithNegativeNumber() {
        double sal = -12.0;
        assertThrows(BusinessException.class, () -> validatePrice(sal));

    }
}