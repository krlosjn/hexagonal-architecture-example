package com.know.hexagonalarquitecture.domain.user.ports;

import com.know.hexagonalarquitecture.domain.user.model.UserPerson;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<UserPerson> listUsers();
    UserPerson saveUser(UserPerson user);
    boolean userExist(Long id);
    UserPerson findOneUser(Long id);
    UserPerson updateUserPerson(UserPerson userPerson, Long id);
    void deleteUser(Long id);

}
