package com.know.hexagonalarchitecture.domain.user.ports;

import com.know.hexagonalarchitecture.domain.user.model.UserPerson;

import java.util.List;

public interface UserRepository {
    List<UserPerson> listUsers();
    UserPerson saveUser(UserPerson user);
    boolean userExist(Long id);
    UserPerson findOneUser(Long id);
    UserPerson updateUserPerson(UserPerson userPerson, Long id);
    void deleteUser(Long id);

}
