package com.know.hexagonalarchitecture.usecase.user;

import com.know.hexagonalarchitecture.user.usecasedomain.DeleteUserUseCaseDomain;
import com.know.hexagonalarchitecture.utils.exception.BusinessException;
import org.springframework.stereotype.Service;


@Service
public class DeleteUserUseCase {

    private final DeleteUserUseCaseDomain deleteUserUseCaseDomain;

    public DeleteUserUseCase(DeleteUserUseCaseDomain deleteUserUseCaseDomain){
        this.deleteUserUseCaseDomain=deleteUserUseCaseDomain;
    }


    public String execute(Long id) throws BusinessException {
        return  this.deleteUserUseCaseDomain.deleteUser(id);
    }

}
