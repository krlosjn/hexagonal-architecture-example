package com.know.hexagonalarquitecture.application.user.usecase;

import com.know.hexagonalarquitecture.domain.user.model.UserPerson;
import com.know.hexagonalarquitecture.domain.user.usecasedomain.UpdateUserPersonUseCase;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateUserUseCase {

    private final UpdateUserPersonUseCase updateUserPersonUseCase;

    public UpdateUserUseCase(UpdateUserPersonUseCase updateUserPersonUseCase) {
        this.updateUserPersonUseCase = updateUserPersonUseCase;
    }

    public Optional<UserPerson> execute(UserPerson userPerson, String dniUser){
       return this.updateUserPersonUseCase.updateUser(userPerson,dniUser);
    }

}
