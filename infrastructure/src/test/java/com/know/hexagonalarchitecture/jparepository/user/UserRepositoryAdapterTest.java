package com.know.hexagonalarchitecture.jparepository.user;

import com.know.hexagonalarchitecture.jparepository.DataMapper;
import com.know.hexagonalarchitecture.product.model.ProductBuilder;
import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.user.model.UserPersonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryAdapterTest {

    @InjectMocks
    private UserRepositoryAdapter adapter;

    @Mock
    private UserDataRepository repository;

    @Mock
    private DataMapper dataMapper;


    @Test
    public void shouldSaveUser(){


        UserPersonData data = new UserPersonData();

        when(repository.save(any()))
                .thenReturn(data);

        when(dataMapper.toData((UserPerson) any()))
                .thenReturn(new UserPersonData());

        when(dataMapper.toEntity((UserPersonData) any()))
                .thenReturn(new UserPersonBuilder().build());

        assertNotNull(adapter.saveUser(new UserPersonBuilder().build()));

    }


    @Test
    public void shouldShowUsers(){

        when(repository.findAll())
                .thenReturn(Collections.singletonList(new UserPersonData()));

        assertNotNull(adapter.listUsers());
    }


    @Test
    public void shouldOneUser(){

        when(repository.findById(anyLong()))
                .thenReturn(Optional.of(new UserPersonData()));

        when(dataMapper.toEntity((UserPersonData) any()))
                .thenReturn(new UserPersonBuilder().build());

        assertNotNull(adapter.findOneUser(1L));
    }


    @Test
    public void shouldUpdateUser(){

        when(repository.findById(anyLong()))
                .thenReturn(Optional.of(new UserPersonData()));

        when(repository.save(any()))
                .thenReturn(new UserPersonData());

        when(dataMapper.toEntity((UserPersonData) any()))
                .thenReturn( new UserPersonBuilder().build());

        assertNotNull(adapter.updateUserPerson(new UserPersonBuilder()
                .withId(1L).withTypeDocument("C").withNmDocument("1234567890")
                .withProducts(Collections.singletonList(new ProductBuilder().build())).build(), 1L));
    }

}