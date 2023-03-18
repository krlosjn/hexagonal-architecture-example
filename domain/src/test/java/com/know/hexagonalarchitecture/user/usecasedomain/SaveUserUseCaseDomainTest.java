package com.know.hexagonalarchitecture.user.usecasedomain;


import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.user.model.UserPersonBuilder;
import com.know.hexagonalarchitecture.user.ports.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class SaveUserUseCaseDomainTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private SaveUserUseCaseDomain saveUserUseCaseDomain;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldSaveUser() throws Exception {


        UserPerson userOne= new UserPersonBuilder()
                .withId(1L)
                .withDniUser("1234567890")
                .withName("Maria")
                .withLastName("Ramirez")
                .build();

        when(userRepository.saveUser(userOne))
                .thenReturn(userOne);


        UserPerson rs= saveUserUseCaseDomain.saveUser(userOne);

        assertEquals(rs,userOne);

    }

}