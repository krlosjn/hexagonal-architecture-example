package com.know.hexagonalarchitecture.user.ports;

import com.know.hexagonalarchitecture.user.model.UserPerson;

import java.util.List;

public interface UserRepository {
    List<UserPerson> listUsers();
    UserPerson saveUser(UserPerson user);
    boolean userExist(Long id);
    UserPerson findOneUser(Long id);
    UserPerson updateUserPerson(UserPerson userPerson, Long id);
    void deleteUser(Long id);

}
