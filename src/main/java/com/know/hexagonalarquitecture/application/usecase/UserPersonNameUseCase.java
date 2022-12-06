package com.know.hexagonalarquitecture.application.usecase;

import com.know.hexagonalarquitecture.domain.usuario.model.UserPerson;
import com.know.hexagonalarquitecture.domain.usuario.ports.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserPersonNameUseCase {


    private final UserRepository repository;

    public UserPersonNameUseCase(UserRepository userRepository){
        this.repository=userRepository;
    }


    public List<UserPerson> listPersonName(String name){
        return this.repository.findUserName(name);
    }


}
