package com.know.hexagonalarchitecture.helpers.dto;

import com.know.hexagonalarchitecture.product.model.Product;
import com.know.hexagonalarchitecture.product.model.ProductBuilder;
import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.user.model.UserPersonBuilder;

public class DtoFactory {

    public static Product createProduct(ProductDto productDto){
        Product product = new ProductBuilder()
                .withId(productDto.getIdProduct())
                .withName(productDto.getName())
                .withPrice(productDto.getPrice())
                .withIdUser(productDto.getIdUser())
                .build();
        return product;
    }

    public static UserPerson createUser(UserPersonDto userDto){
        UserPerson user = new UserPersonBuilder()
                .withId(userDto.getIdUser())
                .withNmDocument(userDto.getNumberDocument())
                .withName(userDto.getName())
                .withLastName(userDto.getLastName())
                .withProducts(userDto.getProducts())
                .withTypeDocument(userDto.getTypeDocument())
                .build();
        return user;
    }

}
