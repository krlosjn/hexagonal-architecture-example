package com.know.hexagonalarchitecture.user.usecasedomain;

import com.know.hexagonalarchitecture.testDataBuilder.UserPersonTestDataBuilder;
import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.user.ports.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
public class SaveUserUseCaseDomainTest {

    @InjectMocks
    private SaveUserUseCaseDomain saveUserUseCaseDomain;

    @Mock
    private UserRepository userRepository;
    @Test
    public void shouldSaveUser() throws Exception {

        //UserRepository userRepository = mock(UserRepository.class);


      //  SaveUserUseCaseDomain saveUserUseCaseDomain = new SaveUserUseCaseDomain(userRepository);

        UserPerson user = new UserPersonTestDataBuilder()
                .build();
        when(userRepository.saveUser(any())).thenReturn(user);

        UserPerson result = saveUserUseCaseDomain.saveUser(user);

        System.out.println("objeto de respuesta " + result.getNumberDocument());

        assertEquals(user, result);
    }


}