package com.know.hexagonalarchitecture.usecase.user;


import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.user.ports.UserRepository;
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
