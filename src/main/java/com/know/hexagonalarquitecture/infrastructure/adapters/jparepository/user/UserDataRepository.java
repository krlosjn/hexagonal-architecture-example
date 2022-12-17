package com.know.hexagonalarquitecture.infrastructure.adapters.jparepository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface UserDataRepository extends JpaRepository<UserPersonData,Long> {
    @Transactional(readOnly=true)
    Optional<UserPersonData> findByDniUser(String dniUser);

    @Transactional(readOnly = true)
    UserPersonData findByName(String name);

}