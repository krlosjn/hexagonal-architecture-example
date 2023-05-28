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

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FindOneUserTest extends TestCase {

    @InjectMocks
    private FindOneUserUseCase findOneUserUseCase;

    @Mock
    private UserRepository repository;

    @Test
    public void shouldFindOneUserOnly(){

        UserPerson user = new UserPersonBuilder().withId(1L)
                        .withName("PEPE").withTypeDocument("C").withNmDocument("1234524712")
                        .build();

        when(repository.findOneUser(anyLong()))
                .thenReturn(user);

        assertNotNull(findOneUserUseCase.execute(1L));
    }

}