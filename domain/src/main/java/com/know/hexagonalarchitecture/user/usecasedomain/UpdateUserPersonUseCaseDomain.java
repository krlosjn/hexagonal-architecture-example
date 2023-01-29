package com.know.hexagonalarchitecture.user.usecasedomain;

import com.know.hexagonalarchitecture.user.exception.UserNotFoundException;
import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.user.ports.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UpdateUserPersonUseCaseDomain {

    public static final String USER_IT_CANTBE_UPDATE = "El usuario no se puede actualizar por que no está registrado";
    private final UserRepository userRepository;

    public UpdateUserPersonUseCaseDomain(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserPerson updateUser(UserPerson userPerson, Long id){
        validateIfUserExist(id);
        return this.userRepository.updateUserPerson(userPerson,id);
    }

    private void validateIfUserExist(Long id){
        if(!this.userRepository.userExist(id)){
            throw  new UserNotFoundException(USER_IT_CANTBE_UPDATE);
        }
    }
}
