package com.know.hexagonalarchitecture.infrastructure.configuration;

import com.know.hexagonalarchitecture.application.user.usecase.ListUsersUseCase;
import com.know.hexagonalarchitecture.domain.product.model.ProductBuilder;
import com.know.hexagonalarchitecture.domain.user.model.UserPersonBuilder;
import com.know.hexagonalarchitecture.domain.user.ports.UserRepository;
import com.know.hexagonalarchitecture.infrastructure.adapters.jparepository.DataMapper;
import com.know.hexagonalarchitecture.infrastructure.helpers.buildersdto.DetailDataDtoBuilder;
import com.know.hexagonalarchitecture.infrastructure.helpers.buildersdto.ObjectDtoBuilder;
import com.know.hexagonalarchitecture.infrastructure.helpers.dto.DataFactory;
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
