package com.know.hexagonalarchitecture.user.usecasedomain;

import com.know.hexagonalarchitecture.testDataBuilder.UserPersonTestDataBuilder;
import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.user.ports.UserRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SaveUserUseCaseDomainTest {

    @InjectMocks
    private SaveUserUseCaseDomain saveUserUseCaseDomain;

    @Mock
    private UserRepository userRepository;
    @Test
    public void shouldSaveUser() throws Exception {

        UserPerson user = new UserPersonTestDataBuilder()
                .build();
        when(userRepository.saveUser(any())).thenReturn(user);
        UserPerson result = saveUserUseCaseDomain.saveUser(user);
        assertEquals(user, result);
    }

}