package com.know.hexagonalarchitecture.user.usecasedomain;


import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.user.ports.UserRepository;
import com.know.hexagonalarchitecture.utils.exception.BusinessException;
import com.know.hexagonalarchitecture.utils.exception.BusinessExceptionMessage;



public class UpdateUserPersonUseCaseDomain {
    private final UserRepository userRepository;

    public UpdateUserPersonUseCaseDomain(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserPerson updateUser(UserPerson userPerson, Long id) throws BusinessException {
        validateIfUserExist(id);
        return this.userRepository.updateUserPerson(userPerson,id);
    }

    private void validateIfUserExist(Long id) throws BusinessException {
        if(!this.userRepository.userExist(id)){
            throw  new BusinessException(BusinessExceptionMessage.USERITCANTBEUPDATE.toString());
        }
    }
}
