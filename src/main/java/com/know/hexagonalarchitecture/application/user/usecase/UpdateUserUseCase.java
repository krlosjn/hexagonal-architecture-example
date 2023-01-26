package com.know.hexagonalarchitecture.application.user.usecase;

import com.know.hexagonalarchitecture.domain.user.model.UserPerson;
import com.know.hexagonalarchitecture.domain.user.usecasedomain.UpdateUserPersonUseCaseDomain;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserUseCase {

    private final UpdateUserPersonUseCaseDomain updateUserPersonUseCase;

    public UpdateUserUseCase(UpdateUserPersonUseCaseDomain updateUserPersonUseCase) {
        this.updateUserPersonUseCase = updateUserPersonUseCase;
    }

    public UserPerson execute(UserPerson userPerson, Long id){
       return this.updateUserPersonUseCase.updateUser(userPerson,id);
    }

}
