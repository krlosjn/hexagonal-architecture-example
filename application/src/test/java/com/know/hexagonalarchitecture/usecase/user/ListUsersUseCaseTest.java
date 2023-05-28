package com.know.hexagonalarchitecture.usecase.user;

import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.user.model.UserPersonBuilder;
import com.know.hexagonalarchitecture.user.ports.UserRepository;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ListUsersUseCaseTest extends TestCase {

    @InjectMocks
    private ListUsersUseCase listUsersUseCase;
    @Mock
    private UserRepository repository;

    @Test
    public void shouldFindAllUsers(){

        UserPerson user = new UserPersonBuilder().withId(1L)
                .withName("PEPE").withTypeDocument("C").withNmDocument("1234524712")
                .build();

        when(repository.listUsers())
                .thenReturn(Collections.singletonList(user));

        assertNotNull(listUsersUseCase.execute());
    }

}