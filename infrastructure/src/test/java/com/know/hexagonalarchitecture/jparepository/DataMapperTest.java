package com.know.hexagonalarchitecture.jparepository;

import com.know.hexagonalarchitecture.jparepository.user.UserPersonData;
import com.know.hexagonalarchitecture.product.model.Product;
import com.know.hexagonalarchitecture.product.model.ProductBuilder;
import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.user.model.UserPersonBuilder;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;

public class DataMapperTest{


    @Test
    public void shouldConvertEntity(){
        UserPersonData data = new UserPersonData();
        DataMapper dataMapper= new DataMapper();
        data.setTypeDocument("C");
        data.setNumberDocument("1234567890");
        assertNotNull(dataMapper.toEntity(data));
    }

    @Test
    public void validateProductsIsNotEmpty(){
        UserPersonData data = new UserPersonData();
        DataMapper dataMapper= new DataMapper();
        data.setTypeDocument("C");
        data.setNumberDocument("1234567890");
        data.setProducts(Arrays.asList(
                dataMapper.toData(new ProductBuilder()
                        .withId(1L)
                        .withIdUser(1L)
                        .withName("ss").build())));

        assertNotNull(dataMapper.toEntity(data));
    }

    @Test
    public void createDataProduct(){
        DataMapper dataMapper= new DataMapper();

        Product product = new ProductBuilder()
                .withId(1L)
                .withIdUser(1L)
                .withName("shirt")
                .withPrice(200.0)
                .build();

        assertNotNull(dataMapper.toData(product));
    }

    @Test
    public void createDataUser(){
        DataMapper dataMapper= new DataMapper();

        UserPerson userPerson = new UserPersonBuilder()
                .withId(1L)
                .withTypeDocument("C")
                .withNmDocument("1234567890")
                .build();
        assertNotNull(dataMapper.toData(userPerson));
    }
}