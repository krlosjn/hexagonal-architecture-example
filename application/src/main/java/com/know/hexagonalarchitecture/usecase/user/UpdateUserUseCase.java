package com.know.hexagonalarchitecture.usecase.user;


import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.user.usecasedomain.UpdateUserPersonUseCaseDomain;
import com.know.hexagonalarchitecture.utils.exception.BusinessException;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserUseCase {

    private final UpdateUserPersonUseCaseDomain updateUserPersonUseCase;

    public UpdateUserUseCase(UpdateUserPersonUseCaseDomain updateUserPersonUseCase) {
        this.updateUserPersonUseCase = updateUserPersonUseCase;
    }

    public UserPerson execute(UserPerson userPerson, Long id) throws BusinessException {
       return this.updateUserPersonUseCase.updateUser(userPerson,id);
    }

}
