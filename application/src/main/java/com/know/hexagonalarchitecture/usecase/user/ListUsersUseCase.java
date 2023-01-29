package com.know.hexagonalarchitecture.usecase.user;


import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.user.ports.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListUsersUseCase {

    private final UserRepository userRepository;

    public ListUsersUseCase(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    public List<UserPerson> execute(){
           return  this.userRepository.listUsers();
    }


}
