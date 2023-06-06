package com.know.hexagonalarchitecture.jparepository.user;


import com.know.hexagonalarchitecture.jparepository.DataMapper;
import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.user.ports.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;


@Repository
public class UserRepositoryAdapter implements UserRepository {

    @Autowired
    private  UserDataRepository repository;
    @Autowired
    private DataMapper dataMapper;

    public UserRepositoryAdapter(UserDataRepository repository, DataMapper dataMapper){
        this.repository=repository;
        this.dataMapper=dataMapper;
    }


    @Override
    public List<UserPerson> listUsers(){
        return this.repository.findAll().stream()
                .map(user-> this.dataMapper.toEntity(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserPerson saveUser(UserPerson user) {
        return this.dataMapper.toEntity(repository.save(this.dataMapper.toData(user)));
    }

    @Override
    public boolean userExist(Long id) {
        if(this.repository.existsUserByIdUser(id)){
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
            person.setProducts(userPerson.getProducts().stream().map(item->this.dataMapper.toData(item)).collect(Collectors.toList()));
            return dataMapper.toEntity(repository.save(person));
        }).orElse(null);

        return userUpdate;
    }

    @Override
    public void deleteUser(Long id) {
        this.repository.deleteById(id);
    }

}
