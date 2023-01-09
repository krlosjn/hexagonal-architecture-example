package com.know.hexagonalarquitecture.domain.user.usecasedomain;

import com.know.hexagonalarquitecture.domain.user.exception.UserNotFoundException;
import com.know.hexagonalarquitecture.domain.user.ports.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserUseCaseDomain {

    public static final String USER_CANT_BE_DELETE = "El usuario no se puede eliminar, es posible que no exista";
    private final  UserRepository repository;

    public DeleteUserUseCaseDomain(UserRepository repository){
        this.repository=repository;
    }


    public String deleteUser(Long id){
        if(!this.repository.userExist(id)){
            throw  new UserNotFoundException(USER_CANT_BE_DELETE);
        }
        this.repository.deleteUser(id);
        return " el usuario con id " + id + " ha sido eliminado con éxito ";
    }

}
