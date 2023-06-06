package com.know.hexagonalarchitecture.jparepository.user;

import com.know.hexagonalarchitecture.jparepository.DataMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryAdapterTest {

    @InjectMocks
    private UserRepositoryAdapter adapter;

    @Mock
    private UserDataRepository repository;

    @Mock
    private DataMapper dataMapper;



    @Test
    public void nothingTest(){


    }
    /*
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


*/

}