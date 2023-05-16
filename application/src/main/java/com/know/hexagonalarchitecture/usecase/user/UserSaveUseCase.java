package com.know.hexagonalarchitecture.usecase.user;


import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.user.usecasedomain.SaveUserUseCaseDomain;
import org.springframework.stereotype.Service;

@Service
public class UserSaveUseCase {

    private final SaveUserUseCaseDomain saveUserDomain;

    public UserSaveUseCase(SaveUserUseCaseDomain saveUserDomain){
        this.saveUserDomain=saveUserDomain;
    }

    public UserPerson execute(UserPerson userPerson) throws Exception {
      return  this.saveUserDomain.saveUser(userPerson);
    }
}
