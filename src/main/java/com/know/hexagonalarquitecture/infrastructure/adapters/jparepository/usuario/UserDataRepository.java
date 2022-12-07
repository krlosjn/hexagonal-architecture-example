package com.know.hexagonalarquitecture.infrastructure.adapters.jparepository.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDataRepository extends JpaRepository<UserPersonData,Long> {
    @Transactional(readOnly=true)
    UserPersonData findByDniUser(String dniUser);

    @Transactional(readOnly = true)
    List<UserPersonData> findAllByName(String name);

}