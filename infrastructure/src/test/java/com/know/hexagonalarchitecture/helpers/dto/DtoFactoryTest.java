package com.know.hexagonalarchitecture.helpers.dto;

import org.junit.Test;

import static com.know.hexagonalarchitecture.helpers.dto.DtoFactory.createProduct;
import static com.know.hexagonalarchitecture.helpers.dto.DtoFactory.createUser;
import static org.junit.Assert.assertNotNull;

public class DtoFactoryTest  {


    @Test
    public void shouldConvertEntityToDomainProduct(){
        ProductDto dto = new ProductDto();
        dto.setIdProduct(1L);
        dto.setName("SS");
        dto.setPrice(20.0);
        assertNotNull(createProduct(dto));
    }


    @Test
    public void shouldConvertDtoToEntityDomain(){

        UserPersonDto dto = new UserPersonDto();
        dto.setIdUser(1L);
        dto.setName("Maria");
        dto.setTypeDocument("C");
        dto.setNumberDocument("1234567890");

        assertNotNull(createUser(dto));
    }
}