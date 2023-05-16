package com.know.hexagonalarchitecture.user.usecasedomain;

import com.know.hexagonalarchitecture.user.ports.UserRepository;
import com.know.hexagonalarchitecture.utils.exception.BusinessException;
import com.know.hexagonalarchitecture.utils.exception.BusinessExceptionMessage;


public class DeleteUserUseCaseDomain {

    private final UserRepository repository;

    public DeleteUserUseCaseDomain(UserRepository repository){
        this.repository=repository;
    }

    public String deleteUser(Long id) throws BusinessException {
        if(!this.repository.userExist(id)){
            throw  new BusinessException(BusinessExceptionMessage.USERCANTBEDELETE.toString());
        }
        this.repository.deleteUser(id);
        return " el usuario con id " + id + " ha sido eliminado con éxito ";
    }

}
