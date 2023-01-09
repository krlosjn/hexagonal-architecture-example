package com.know.hexagonalarquitecture.application.user.usecase;


import com.know.hexagonalarquitecture.domain.user.model.UserPerson;
import com.know.hexagonalarquitecture.domain.user.usecasedomain.SaveUserUseCaseDomain;
import org.springframework.stereotype.Component;

@Component
public class UserSaveUseCase {

    private final SaveUserUseCaseDomain saveUserDomain;

    public UserSaveUseCase(SaveUserUseCaseDomain saveUserDomain){
        this.saveUserDomain=saveUserDomain;
    }

    public UserPerson execute(UserPerson userPerson) throws Exception {
      return  this.saveUserDomain.saveUser(userPerson);
    }
}
