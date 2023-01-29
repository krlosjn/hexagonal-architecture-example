package com.know.hexagonalarchitecture.jparepository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.transaction.annotation.Transactional;

public interface UserDataRepository extends JpaRepository<UserPersonData,Long> {
    @Transactional(readOnly=true)
    boolean findByDniUser(String dniUser);

    @Transactional(readOnly = true)
    UserPersonData findByName(String name);

    @Transactional
    boolean existsUserById(Long id);

}