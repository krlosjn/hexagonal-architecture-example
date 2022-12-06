package com.know.hexagonalarquitecture.application.usecase;


import com.know.hexagonalarquitecture.domain.usuario.model.UserPerson;
import com.know.hexagonalarquitecture.domain.usuario.usecasedomain.SaveUserUseCase;
import org.springframework.stereotype.Component;

@Component
public class UserSaveUseCase {

    private final SaveUserUseCase saveUserDomain;

    public UserSaveUseCase(SaveUserUseCase saveUserDomain){
        this.saveUserDomain=saveUserDomain;
    }

    public UserPerson execute(UserPerson userPerson) throws Exception {
      return  this.saveUserDomain.saveUser(userPerson);
    }
}
