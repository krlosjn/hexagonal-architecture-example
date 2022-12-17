package com.know.hexagonalarquitecture.infrastructure.adapters.jparepository.user;

import com.know.hexagonalarquitecture.domain.user.model.UserPerson;
import com.know.hexagonalarquitecture.domain.user.ports.UserRepository;
import com.know.hexagonalarquitecture.infrastructure.adapters.jparepository.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public boolean userExist(String dniUser) {
        if(this.repository.findByDniUser(dniUser)!=null){
            return true;
        };
        return  false;
    }

    @Override
    public UserPerson findUserName(String name) {
        return this.dataMapper.toEntity(this.repository.findByName(name));
    }


    /**
     * implementation for update one user
     * */
    @Override
    public Optional<UserPerson> updateUserPerson(UserPerson userPerson, String dniUser) {
         UserPerson userUpdate= repository.findByDniUser(dniUser).map(person->{
            person.setName(userPerson.getName());
            person.setLastName(userPerson.getLastName());
            return saveUser(this.dataMapper.toEntity(person));
        }).orElse(null);

         return Optional.of(userUpdate);
    }
}
