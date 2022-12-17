package com.know.hexagonalarquitecture.domain.user.ports;

import com.know.hexagonalarquitecture.domain.user.model.UserPerson;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<UserPerson> listUsers();
    UserPerson saveUser(UserPerson user);
    boolean userExist(String dniUser);
    UserPerson findUserName(String name);
    Optional<UserPerson> updateUserPerson(UserPerson userPerson, String dniUser);

}
