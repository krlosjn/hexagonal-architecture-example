package com.know.hexagonalarchitecture.user.usecasedomain;

import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.user.model.UserPersonBuilder;
import com.know.hexagonalarchitecture.user.ports.UserRepository;
import com.know.hexagonalarchitecture.utils.exception.BusinessException;
import com.know.hexagonalarchitecture.utils.exception.BusinessExceptionMessage;

import static com.know.hexagonalarchitecture.utils.ValidateArgument.*;


public class SaveUserUseCaseDomain {

    private final UserRepository userRepository;

    public SaveUserUseCaseDomain(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public UserPerson saveUser(UserPerson user) throws Exception {

            validateUserRepeat(user);
            validateMandatory(user.getName());
            validateMandatory(user.getLastName());

            UserPerson userToSave= new UserPersonBuilder()
                .withId(user.getIdUser())
                    .withTypeDocument(validateTypeDocument(user.getTypeDocument()))
                    .withNmDocument(validateStringDocumentNumber(user.getNumberDocument()))
                    .withDniUser(user.getTypeDocument()+user.getNumberDocument())
                    .withName(user.getName())
                    .withLastName(user.getLastName())
                    .withProducts(user.getProducts())
                    .build();
           return this.userRepository.saveUser(userToSave);
    }


    protected void validateUserRepeat(UserPerson userPerson) throws BusinessException {
        if(this.userRepository.userExist(userPerson.getIdUser())){
            throw new BusinessException(BusinessExceptionMessage.THEUSERISREGISTEREDBEFORE.toString() + " dniUser " + userPerson.getDniUser() + " id usuari " + userPerson.getIdUser());
        }
    }
}
