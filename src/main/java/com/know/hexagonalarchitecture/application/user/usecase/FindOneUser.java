package com.know.hexagonalarchitecture.application.user.usecase;

import com.know.hexagonalarchitecture.domain.user.model.UserPerson;
import com.know.hexagonalarchitecture.domain.user.ports.UserRepository;
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
