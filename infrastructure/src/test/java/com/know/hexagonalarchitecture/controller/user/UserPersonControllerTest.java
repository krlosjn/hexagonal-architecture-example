package com.know.hexagonalarchitecture.controller.user;

import com.know.hexagonalarchitecture.helpers.dto.DataFactory;
import com.know.hexagonalarchitecture.helpers.dto.ObjectDto;
import com.know.hexagonalarchitecture.helpers.dto.UserPersonDto;
import com.know.hexagonalarchitecture.usecase.user.FindOneUserUseCase;
import com.know.hexagonalarchitecture.usecase.user.ListUsersUseCase;
import com.know.hexagonalarchitecture.usecase.user.UpdateUserUseCase;
import com.know.hexagonalarchitecture.usecase.user.UserSaveUseCase;
import com.know.hexagonalarchitecture.user.model.UserPerson;
import com.know.hexagonalarchitecture.user.model.UserPersonBuilder;
import com.know.hexagonalarchitecture.utils.exception.BusinessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserPersonControllerTest {

    @InjectMocks
    private  UserPersonController controller;
    @Mock
    private UserSaveUseCase userSaveUseCase;
    @Mock
    private FindOneUserUseCase findOneUserUseCase;
    @Mock
    private ListUsersUseCase listUsersUseCase;
    @Mock
    private UpdateUserUseCase updateUserUseCase;
    @Mock
    private DataFactory factory;

    @Test
    public void shouldSaveUser() throws Exception {

        //arrange
        UserPersonDto dto = new UserPersonDto();
        dto.setIdUser(1L);
        dto.setTypeDocument("C");
        dto.setNumberDocument("1234567890");
        dto.setName("anything");

        UserPerson user = new UserPersonBuilder().build();


        when(userSaveUseCase.execute(any()))
            .thenReturn(user);

        when(factory.buildResponse(any(), any(), any()))
                .thenReturn(new ObjectDto());

        //act
        ResponseEntity<ObjectDto> response =  controller.saveUser(dto);

        //assert
        assertEquals(HttpStatus.CREATED,response.getStatusCode());

    }


    @Test
    public void shouldShowUserList(){

       when(listUsersUseCase.execute())
               .thenReturn(Collections.singletonList(new UserPersonBuilder().build()));

        ResponseEntity<ObjectDto> response = controller.listAllUsers();

        assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    @Test
    public void shouldShowOneUser(){

        when(findOneUserUseCase.execute(anyLong()))
                .thenReturn(new UserPersonBuilder().build());

        assertNotNull(controller.listUser(1L));

    }


    @Test
    public void shouldUpdateUser() throws BusinessException {
        UserPersonDto dto = new UserPersonDto();
        dto.setIdUser(1L);
        dto.setTypeDocument("C");
        dto.setNumberDocument("1234567890");
        Long idUser=1L;
        when(updateUserUseCase.execute(any(),anyLong()))
                .thenReturn(new UserPersonBuilder().build());

        ResponseEntity<ObjectDto> response = controller.updatingUser(dto,idUser);

        assertEquals(HttpStatus.OK,response.getStatusCode());
    }

}