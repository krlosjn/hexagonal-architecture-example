package com.know.hexagonalarquitecture.infrastructure.adapters.jparepository;

import com.know.hexagonalarquitecture.domain.usuario.model.UserPerson;
import com.know.hexagonalarquitecture.domain.usuario.model.UserPersonBuilder;
import com.know.hexagonalarquitecture.infrastructure.adapters.jparepository.usuario.UserPersonData;
import org.springframework.beans.factory.annotation.Autowired;


public class DataMapper {
//clase que mapea la entidad a base de datos tabla y viceversa

    @Autowired
    private final UserPersonBuilder userPersonBuilder;

    public DataMapper(UserPersonBuilder userPersonBuilder){
    this.userPersonBuilder=userPersonBuilder;
   }
    public  UserPerson toEntity(UserPersonData userPersonData){
    UserPersonBuilder userPersonBuilder = new UserPersonBuilder();

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

}
