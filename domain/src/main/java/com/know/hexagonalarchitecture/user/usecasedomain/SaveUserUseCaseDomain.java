package com.know.hexagonalarchitecture.user.usecasedomain;

import com.know.hexagonalarchitecture.user.exception.UserRepeatException;
import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.user.ports.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveUserUseCaseDomain {

    public static final String THE_USER_IS_ALREADR_REGISTERED = "El usuario ya se encuentra registrado";
    private final UserRepository userRepository;

    public SaveUserUseCaseDomain(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public UserPerson saveUser(UserPerson user) throws Exception {
        validateUserRepeat(user);
       return this.userRepository.saveUser(user);
    }


    private void validateUserRepeat(UserPerson userPerson){
        if(this.userRepository.userExist(userPerson.getId())){
            throw new UserRepeatException(THE_USER_IS_ALREADR_REGISTERED + " dniUser " + userPerson.getDniUser() + " id usuari " + userPerson.getId());
        }

    }
}
