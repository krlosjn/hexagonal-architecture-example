package com.know.hexagonalarquitecture.domain.usuario.ports;

import com.know.hexagonalarquitecture.domain.usuario.model.UserPerson;

import java.util.List;

public interface UserRepository {
    List<UserPerson> listUsers();

    UserPerson saveUser(UserPerson user);

    UserPerson userExist(String dni);

    List<UserPerson> findUserName(String name);
}
