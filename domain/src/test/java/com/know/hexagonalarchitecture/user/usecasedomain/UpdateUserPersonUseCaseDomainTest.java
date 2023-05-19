package com.know.hexagonalarchitecture.user.usecasedomain;

import com.know.hexagonalarchitecture.testDataBuilder.UserPersonTestDataBuilder;
import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.user.ports.UserRepository;
import com.know.hexagonalarchitecture.utils.exception.BusinessException;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UpdateUserPersonUseCaseDomainTest extends TestCase {

    @InjectMocks
    private UpdateUserPersonUseCaseDomain update;

    @Mock
    private UserRepository repository;

    @Test
    public void shouldUpdateUser() throws BusinessException {

        UserPerson user= new UserPersonTestDataBuilder().build();
        UserPerson user2= new UserPersonTestDataBuilder().withIdUser(1L).build();
        when(repository.userExist(anyLong()))
                .thenReturn(true);
        when(repository.updateUserPerson(any(),anyLong()))
                .thenReturn(user);
        assertNotNull(update.updateUser(user2,1L));
    }

}