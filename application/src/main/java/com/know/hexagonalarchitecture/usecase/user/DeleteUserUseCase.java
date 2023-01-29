package com.know.hexagonalarchitecture.usecase.user;



import com.know.hexagonalarchitecture.user.usecasedomain.DeleteUserUseCaseDomain;
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
