package com.know.hexagonalarquitecture.infrastructure.adapters.jparepository.user;

import com.know.hexagonalarquitecture.domain.user.model.UserPerson;
import com.know.hexagonalarquitecture.domain.user.ports.UserRepository;
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
    public boolean userExist(Long id) {
        if(this.repository.existsUserById(id)){
            return true;
        }
        return false;
    }

    @Override
    public UserPerson findOneUser(Long id) {
        return dataMapper.toEntity(this.repository.findById(id).get());
    }


    @Override
    public UserPerson updateUserPerson(UserPerson userPerson, Long id) {

        UserPerson userUpdate = repository.findById(id).map(person->{
            person.setName(userPerson.getName());
            person.setLastName(userPerson.getLastName());
            person.setDniUser(userPerson.getDniUser());
            return dataMapper.toEntity(repository.save(person));
        }).orElse(null);

        return userUpdate;
    }

}
