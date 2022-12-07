package com.know.hexagonalarquitecture.application.usecase;

import com.know.hexagonalarquitecture.domain.usuario.model.UserPerson;
import com.know.hexagonalarquitecture.domain.usuario.ports.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserPersonNameFindUseCase {


    private final UserRepository repository;

    public UserPersonNameFindUseCase(UserRepository userRepository){
        this.repository=userRepository;
    }


    public List<UserPerson> execute(String name){
        return this.repository.findUserName(name);
    }


}
