package com.know.hexagonalarquitecture.domain.user.usecasedomain;

import com.know.hexagonalarquitecture.domain.user.exception.UserRepeatException;
import com.know.hexagonalarquitecture.domain.user.model.UserPerson;
import com.know.hexagonalarquitecture.domain.user.ports.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveUserUseCase {

    public static final String THE_USER_IS_ALREADR_REGISTERED = "El usuario ya se encuentra registrado";
    private final UserRepository userRepository;

    public SaveUserUseCase(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public UserPerson saveUser(UserPerson user) throws Exception {
        validateUserRepeat(user);
       return this.userRepository.saveUser(user);
    }


    private void validateUserRepeat(UserPerson userPerson){
        if(this.userRepository.userExist(userPerson.getDniUser())){
            throw new UserRepeatException(THE_USER_IS_ALREADR_REGISTERED);
        }

    }
}
