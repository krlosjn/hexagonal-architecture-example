package com.know.hexagonalarquitecture.domain.user.usecasedomain;

import com.know.hexagonalarquitecture.domain.user.exception.UserNotFoundException;
import com.know.hexagonalarquitecture.domain.user.model.UserPerson;
import com.know.hexagonalarquitecture.domain.user.ports.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUserPersonUseCase {

    public static final String USER_IT_CANTBE_UPDATE = "El usuario no se puede actualizar por que no está registrado";
    private final UserRepository userRepository;

    public UpdateUserPersonUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserPerson> updateUser(UserPerson userPerson, String dniUser){
        validateIfUserExist(dniUser);
        return this.userRepository.updateUserPerson(userPerson,dniUser);
    }

    private void validateIfUserExist(String dniUser){
        if(!this.userRepository.userExist(dniUser)){
            throw  new UserNotFoundException(USER_IT_CANTBE_UPDATE);
        }
    }
}
