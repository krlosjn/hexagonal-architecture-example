package com.know.hexagonalarchitecture.controller.user;


import com.know.hexagonalarchitecture.helpers.dto.DataFactory;
import com.know.hexagonalarchitecture.helpers.dto.ObjectDto;
import com.know.hexagonalarchitecture.helpers.dto.UserPersonDto;
import com.know.hexagonalarchitecture.usecase.user.*;
import com.know.hexagonalarchitecture.utils.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;

import static com.know.hexagonalarchitecture.helpers.dto.DtoFactory.createUser;

@RestController
@RequestMapping(value="v1/usuarios")
public class UserPersonController {

    private final UserSaveUseCase userSaveUseCase;
    private final ListUsersUseCase listUsersUseCase;
    private final FindOneUserUseCase findOneUser;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final DataFactory dataFactory;



    public UserPersonController(UserSaveUseCase userSaveUseCase, DataFactory dataFactory,
                                ListUsersUseCase listUsersUseCase, FindOneUserUseCase findOneUser,
                                UpdateUserUseCase updateUserUseCase, DeleteUserUseCase deleteUserUseCase) {
        this.userSaveUseCase = userSaveUseCase;
        this.dataFactory = dataFactory;
        this.listUsersUseCase = listUsersUseCase;
        this.findOneUser = findOneUser;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectDto> saveUser(@RequestBody UserPersonDto userDto) throws Exception {
        return new ResponseEntity<>(this.dataFactory
                .buildResponse("Usuarios", Collections.singletonList(this.userSaveUseCase.
                        execute(createUser(userDto))), null),
                HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectDto> listAllUsers() {

        return new ResponseEntity<>(this.dataFactory
                .buildResponse("Consultar usuarios", Collections.singletonList(this.listUsersUseCase.execute()), null), HttpStatus.OK);
    }

    @PutMapping(value="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectDto> updatingUser(@RequestBody UserPersonDto userDto, @PathVariable("id") Long id) throws BusinessException {

        return new ResponseEntity<>(this.dataFactory.buildResponse("Usuario actualizado ", Arrays.asList(this.updateUserUseCase
                .execute(createUser(userDto),id)),null),HttpStatus.OK);
    }

    @GetMapping(value="/detalle/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectDto> listUser(@PathVariable(value="id") Long id){

        return new ResponseEntity<>( this.dataFactory
                .buildResponse("Consultar usuarios", Collections.singletonList(this.findOneUser.execute(id)),null),HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteUser(@PathVariable(value="id") Long id) throws BusinessException {
        return ResponseEntity.status(HttpStatus.OK).body(this.deleteUserUseCase.execute(id));
    }
}
