package com.know.hexagonalarquitecture.application.user.usecase;

import com.know.hexagonalarquitecture.domain.user.model.UserPerson;
import com.know.hexagonalarquitecture.domain.user.ports.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class FindOneUser {


    private final UserRepository repository;

    public FindOneUser(UserRepository userRepository){
        this.repository=userRepository;
    }


    public UserPerson execute(Long id){
        return this.repository.findOneUser(id);
    }


}
