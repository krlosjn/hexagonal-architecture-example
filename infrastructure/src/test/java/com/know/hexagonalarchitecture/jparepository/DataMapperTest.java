package com.know.hexagonalarchitecture.jparepository;

import com.know.hexagonalarchitecture.jparepository.user.UserPersonData;
import com.know.hexagonalarchitecture.product.model.Product;
import com.know.hexagonalarchitecture.product.model.ProductBuilder;
import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.user.model.UserPersonBuilder;
import org.junit.Test;

import java.util.Arrays;

import static com.know.hexagonalarchitecture.jparepository.DataMapper.toData;
import static com.know.hexagonalarchitecture.jparepository.DataMapper.toEntity;
import static org.junit.Assert.assertNotNull;

public class DataMapperTest{


    @Test
    public void shouldConvertEntity(){
        UserPersonData data = new UserPersonData();
        data.setTypeDocument("C");
        data.setNumberDocument("1234567890");
        assertNotNull(toEntity(data));
    }

    @Test
    public void validateProductsIsNotEmpty(){
        UserPersonData data = new UserPersonData();
        data.setTypeDocument("C");
        data.setNumberDocument("1234567890");
        data.setProducts(Arrays.asList(
                toData(new ProductBuilder()
                        .withId(1L)
                        .withIdUser(1L)
                        .withName("ss").build())));

        assertNotNull(toEntity(data));
    }

    @Test
    public void createDataProduct(){

        Product product = new ProductBuilder()
                .withId(1L)
                .withIdUser(1L)
                .withName("shirt")
                .withPrice(200.0)
                .build();

        assertNotNull(toData(product));
    }

    @Test
    public void createDataUser(){

        UserPerson userPerson = new UserPersonBuilder()
                .withId(1L)
                .withTypeDocument("C")
                .withNmDocument("1234567890")
                .build();
        assertNotNull(toData(userPerson));
    }
}