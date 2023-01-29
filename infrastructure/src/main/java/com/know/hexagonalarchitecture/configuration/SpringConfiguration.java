package com.know.hexagonalarchitecture.configuration;


import com.know.hexagonalarchitecture.helpers.buildersdto.DetailDataDtoBuilder;
import com.know.hexagonalarchitecture.helpers.buildersdto.ObjectDtoBuilder;
import com.know.hexagonalarchitecture.helpers.dto.DataFactory;
import com.know.hexagonalarchitecture.jparepository.DataMapper;
import com.know.hexagonalarchitecture.product.model.ProductBuilder;
import com.know.hexagonalarchitecture.usecase.user.ListUsersUseCase;
import com.know.hexagonalarchitecture.user.model.UserPersonBuilder;
import com.know.hexagonalarchitecture.user.ports.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public DataMapper generateDataMapper(UserPersonBuilder userPersonBuilder, ProductBuilder productBuilder){
        return new DataMapper(userPersonBuilder,productBuilder);
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
    public ListUsersUseCase generateListUserUseCase(UserRepository userRepository){
        return new ListUsersUseCase(userRepository);
    }
}
