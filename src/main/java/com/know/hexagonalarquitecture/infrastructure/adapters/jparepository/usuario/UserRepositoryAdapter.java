package com.know.hexagonalarquitecture.infrastructure.adapters.jparepository.usuario;

import com.know.hexagonalarquitecture.domain.usuario.model.UserPerson;
import com.know.hexagonalarquitecture.domain.usuario.ports.UserRepository;
import com.know.hexagonalarquitecture.infrastructure.adapters.jparepository.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryAdapter implements UserRepository {

    @Autowired
    private  UserDataRepository repository;
    @Autowired
    private final DataMapper dataMapper;

    public UserRepositoryAdapter(UserDataRepository repository, DataMapper dataMapper){
        this.repository=repository;
        this.dataMapper=dataMapper;
    }


    @Override
    public List<UserPerson> listUsers() {
       List<UserPerson> lsPerson= new ArrayList<UserPerson>();
        this.repository.findAll().stream().forEach(item ->{
            lsPerson.add(this.dataMapper.toEntity(item));
        });
        return lsPerson;
    }

    @Override
    public UserPerson saveUser(UserPerson user) {
        return this.dataMapper.toEntity(repository.save(this.dataMapper.toData(user)));
    }

    @Override
    public boolean userExist(String dni) {
        return this.repository.findById(dni);
    }

    @Override
    public List<UserPerson> findUserName(String name) {

        List<UserPerson> lsUser=new ArrayList<UserPerson>();

       this.repository.findAllByName(name).stream()
                .forEach(item -> {
                    lsUser.add(this.dataMapper.toEntity(item));
                });
        return lsUser;
    }
}
