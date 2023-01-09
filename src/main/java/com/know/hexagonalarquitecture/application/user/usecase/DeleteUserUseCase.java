package com.know.hexagonalarquitecture.application.user.usecase;


import com.know.hexagonalarquitecture.domain.user.usecasedomain.DeleteUserUseCaseDomain;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserUseCase {

    private final DeleteUserUseCaseDomain deleteUserUseCaseDomain;

    public DeleteUserUseCase(DeleteUserUseCaseDomain deleteUserUseCaseDomain){
        this.deleteUserUseCaseDomain=deleteUserUseCaseDomain;
    }


    public String execute(Long id){
        return this.deleteUserUseCaseDomain.deleteUser(id);
    }

}
