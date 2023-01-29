package com.know.hexagonalarchitecture.jparepository;


import com.know.hexagonalarchitecture.jparepository.product.ProductData;
import com.know.hexagonalarchitecture.jparepository.user.UserPersonData;
import com.know.hexagonalarchitecture.product.model.Product;
import com.know.hexagonalarchitecture.product.model.ProductBuilder;
import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.user.model.UserPersonBuilder;
import org.springframework.beans.factory.annotation.Autowired;


public class DataMapper {
    @Autowired
    private final UserPersonBuilder userPersonBuilder;
    private final ProductBuilder productBuilder;

    public DataMapper(UserPersonBuilder userPersonBuilder,ProductBuilder productBuilder){
    this.userPersonBuilder=userPersonBuilder;
    this.productBuilder=productBuilder;
   }
    public UserPerson toEntity(UserPersonData userPersonData){

       return  userPersonBuilder.withId(userPersonData.getId())
                .withName(userPersonData.getName())
                .withLastName(userPersonData.getLastName())
                .withDniUser(userPersonData.getDniUser()).build();
    };

    public  UserPersonData toData(UserPerson userPerson){

        UserPersonData data= new UserPersonData();

        data.setId(userPerson.getId());
        data.setName(userPerson.getName());
        data.setLastName(userPerson.getLastName());
        data.setDniUser(userPerson.getDniUser());
        return data;
    };

    public Product toEntity(ProductData data){
        return productBuilder.withId(data.getId())
                .withName(data.getName())
                .withPrice(data.getPrice())
                .build();
    }

    public ProductData toData(Product product){
        ProductData data= new ProductData();
        data.setId(product.getId());
        data.setName(product.getName());
        data.setPrice(product.getPrice());
        return data;
    }
}
