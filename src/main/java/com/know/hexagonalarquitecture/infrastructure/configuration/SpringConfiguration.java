package com.know.hexagonalarquitecture.infrastructure.configuration;

import com.know.hexagonalarquitecture.application.usecase.ListUsersUseCase;
import com.know.hexagonalarquitecture.domain.usuario.model.UserPersonBuilder;
import com.know.hexagonalarquitecture.domain.usuario.ports.UserRepository;
import com.know.hexagonalarquitecture.infrastructure.adapters.jparepository.DataMapper;
import com.know.hexagonalarquitecture.infrastructure.helpers.buildersdto.DetailObjectDtoBuilder;
import com.know.hexagonalarquitecture.infrastructure.helpers.buildersdto.ObjectDtoBuilder;
import com.know.hexagonalarquitecture.infrastructure.helpers.dto.DataFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public ListUsersUseCase generateListUserUseCase(UserRepository userRepository){
        return new ListUsersUseCase(userRepository);
    }

    /*
    @Bean
    public UserRepositoryAdapter generateUserRepositoryAdapter(UserDataRepository repository, DataMapper dataMapper){
        return new UserRepositoryAdapter(repository,dataMapper);
    }*/

    @Bean
    public DataMapper generateDataMapper(UserPersonBuilder userPersonBuilder){
        return new DataMapper(userPersonBuilder);
    }

    @Bean
    public UserPersonBuilder generateUserPersonBuilder(){
        return new UserPersonBuilder();
    }

    @Bean
    public DetailObjectDtoBuilder generateDetailObjectDto(){
        return new DetailObjectDtoBuilder();
    }

    @Bean
    public ObjectDtoBuilder generateObjectDtoBuilder(){
        return new ObjectDtoBuilder();
    }

    @Bean
    public DataFactory generateDataFactory (ObjectDtoBuilder objectDtoBuilder,DetailObjectDtoBuilder detailObjectDtoBuilder){
        return new DataFactory(objectDtoBuilder,detailObjectDtoBuilder);
    }

}
