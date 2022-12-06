package com.know.hexagonalarquitecture.domain.usuario.usecasedomain;

import com.know.hexagonalarquitecture.domain.usuario.exception.UserRepeatException;
import com.know.hexagonalarquitecture.domain.usuario.model.UserPerson;
import com.know.hexagonalarquitecture.domain.usuario.ports.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveUserUseCase {

    public static final String EL_USUARIO_YA_SE_ENCUENTRA_REGISTRADO = "El usuario ya se encuentra registrado";
    private final UserRepository userRepository;

    public SaveUserUseCase(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public UserPerson saveUser(UserPerson user) throws Exception {
        validateUserRepeat(user);
       return this.userRepository.saveUser(user);
    }

    private void validateUserRepeat(UserPerson user) throws Exception {
        if(this.userRepository.userExist(user.getDniUser())){
            throw new UserRepeatException(EL_USUARIO_YA_SE_ENCUENTRA_REGISTRADO);
        }
    }
}
