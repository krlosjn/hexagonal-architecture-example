package com.know.hexagonalarquitecture.application.user.usecase;

import com.know.hexagonalarquitecture.domain.user.model.UserPerson;
import com.know.hexagonalarquitecture.domain.user.ports.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class FindUserNameUseCase {


    private final UserRepository repository;

    public FindUserNameUseCase(UserRepository userRepository){
        this.repository=userRepository;
    }


    public UserPerson execute(String name){
        return this.repository.findUserName(name);
    }


}
