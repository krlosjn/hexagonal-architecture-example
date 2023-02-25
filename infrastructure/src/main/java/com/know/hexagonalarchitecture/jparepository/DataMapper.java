package com.know.hexagonalarchitecture.jparepository;


import com.know.hexagonalarchitecture.jparepository.product.ProductData;
import com.know.hexagonalarchitecture.jparepository.user.UserPersonData;
import com.know.hexagonalarchitecture.product.model.Product;
import com.know.hexagonalarchitecture.product.model.ProductBuilder;
import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.user.model.UserPersonBuilder;
import java.util.Objects;
import java.util.stream.Collectors;


public class DataMapper {

    private  static UserPersonBuilder userPersonBuilder=null;
    private static ProductBuilder productBuilder=null;

    public DataMapper(UserPersonBuilder userPersonBuilder,ProductBuilder productBuilder){
    this.userPersonBuilder=userPersonBuilder;
    this.productBuilder=productBuilder;
   }
    public static UserPerson toEntity(UserPersonData userPersonData){

       return  userPersonBuilder.withId(userPersonData.getIdUser())
                .withName(userPersonData.getName())
                .withLastName(userPersonData.getLastName())
                .withDniUser(userPersonData.getDniUser())
                .withProducts(Objects.isNull(userPersonData.getProducts()) || userPersonData.getProducts().isEmpty()
                       ? null
                       : userPersonData.getProducts().stream().map(DataMapper::toEntity).collect(Collectors.toList())
                )
                .build();
    };

    public static  UserPersonData toData(UserPerson userPerson){

        UserPersonData data= new UserPersonData();

        data.setIdUser(userPerson.getIdUser());
        data.setName(userPerson.getName());
        data.setLastName(userPerson.getLastName());
        data.setDniUser(userPerson.getDniUser());
        data.setProducts(Objects.isNull(userPerson.getProducts()) || userPerson.getProducts().isEmpty()
                ? null
                : userPerson.getProducts().stream().map(DataMapper::toData).collect(Collectors.toList())
        );
        return data;
    };

    public static Product toEntity(ProductData data){
        return productBuilder.withId(data.getIdProduct())
                .withName(data.getName())
                .withPrice(data.getPrice())
                .withIdUser(data.getUsers().getIdUser())
                .build();
    }

    public static ProductData toData(Product product){

        ProductData data= new ProductData();
        UserPersonData userPersonData = new UserPersonData();

        userPersonData.setIdUser(product.getIdUser());

        data.setIdProduct(product.getIdProduct());
        data.setName(product.getName());
        data.setPrice(product.getPrice());
        data.setUsers(userPersonData);

        return data;
    }
}
