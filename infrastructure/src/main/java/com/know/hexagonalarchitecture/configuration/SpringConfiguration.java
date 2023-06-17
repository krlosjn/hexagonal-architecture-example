package com.know.hexagonalarchitecture.configuration;


import com.know.hexagonalarchitecture.helpers.dto.DataFactory;
import com.know.hexagonalarchitecture.helpers.dto.DetailDataDtoBuilder;
import com.know.hexagonalarchitecture.helpers.dto.ObjectDtoBuilder;
import com.know.hexagonalarchitecture.jparepository.DataMapper;
import com.know.hexagonalarchitecture.product.model.ProductBuilder;
import com.know.hexagonalarchitecture.product.ports.ProductRepository;
import com.know.hexagonalarchitecture.product.usecasedomain.DeleteProductUseCaseDomain;
import com.know.hexagonalarchitecture.product.usecasedomain.SaveProductUseCaseDomain;
import com.know.hexagonalarchitecture.product.usecasedomain.UpdateProductUseCaseDomain;
import com.know.hexagonalarchitecture.user.model.UserPersonBuilder;
import com.know.hexagonalarchitecture.user.ports.UserRepository;
import com.know.hexagonalarchitecture.user.usecasedomain.DeleteUserUseCaseDomain;
import com.know.hexagonalarchitecture.user.usecasedomain.SaveUserUseCaseDomain;
import com.know.hexagonalarchitecture.user.usecasedomain.UpdateUserPersonUseCaseDomain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
   @Bean
    public DataMapper generateDataMapper(){
        return new DataMapper();
    }
    @Bean
    public UserPersonBuilder generateUserPersonBuilder(){
        return new UserPersonBuilder();
    }
    @Bean
    public ProductBuilder generateProductBuilder(){return new ProductBuilder();}
    @Bean
    public DetailDataDtoBuilder generateDetailObjectDto(){
        return new DetailDataDtoBuilder();
    }
    @Bean
    public ObjectDtoBuilder generateObjectDtoBuilder(){
        return new ObjectDtoBuilder();
    }
    @Bean
    public DataFactory generateDataFactory (ObjectDtoBuilder objectDtoBuilder, DetailDataDtoBuilder detailObjectDtoBuilder){
        return new DataFactory(objectDtoBuilder,detailObjectDtoBuilder);
    }
    @Bean
    public DeleteUserUseCaseDomain generateUseCaseDeleteDomain(UserRepository repository){
       return new DeleteUserUseCaseDomain(repository);
    }
    @Bean
    public SaveUserUseCaseDomain generatUseCaseSaveDomain(UserRepository repository){
       return new SaveUserUseCaseDomain(repository);
    }
    @Bean
    public UpdateUserPersonUseCaseDomain generateUseCaseUpdateDomain(UserRepository repository){
       return new UpdateUserPersonUseCaseDomain(repository);
    }
    @Bean
    public DeleteProductUseCaseDomain generateUseCaseDeleteProductDomain(ProductRepository repository){
       return new DeleteProductUseCaseDomain(repository);
    }
    @Bean
    public SaveProductUseCaseDomain generateUseCaseProductDoamin(ProductRepository repository){
       return new SaveProductUseCaseDomain(repository);
    }
    @Bean
    public UpdateProductUseCaseDomain generateUseCaseProductDomain(ProductRepository repository){
    return new UpdateProductUseCaseDomain(repository);
   }
}
