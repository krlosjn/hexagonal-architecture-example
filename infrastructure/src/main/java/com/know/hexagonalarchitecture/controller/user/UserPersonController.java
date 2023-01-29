package com.know.hexagonalarchitecture.controller.user;


import com.know.hexagonalarchitecture.helpers.dto.DataFactory;
import com.know.hexagonalarchitecture.helpers.dto.ObjectDto;
import com.know.hexagonalarchitecture.usecase.user.*;
import com.know.hexagonalarchitecture.user.model.UserPerson;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping(value="v1/usuarios")
public class UserPersonController {


    private final UserSaveUseCase userSaveUseCase;
    private final ListUsersUseCase listUsersUseCase;
    private final FindOneUser findOneUser;
    private final UpdateUserUseCase updateUserUseCase;
    private final DataFactory dataFactory;

    private final DeleteUserUseCase deleteUserUseCase;



    public UserPersonController(UserSaveUseCase userSaveUseCase, DataFactory dataFactory, ListUsersUseCase listUsersUseCase, FindOneUser findOneUser, UpdateUserUseCase updateUserUseCase, DeleteUserUseCase deleteUserUseCase){
        this.userSaveUseCase=userSaveUseCase;
        this.dataFactory=dataFactory;
        this.listUsersUseCase=listUsersUseCase;
        this.findOneUser =findOneUser;
        this.updateUserUseCase=updateUserUseCase;
        this.deleteUserUseCase=deleteUserUseCase;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectDto> saveUser(@RequestBody UserPerson userPerson) throws Exception {
        return new ResponseEntity<>( this.dataFactory
                .buildResponse("Usuarios", Arrays.asList(this.userSaveUseCase.execute(userPerson)),null),
                HttpStatus.CREATED);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectDto> listAllUsers(){

        return new ResponseEntity<>( this.dataFactory
                .buildResponse("Consultar usuarios",Arrays.asList(this.listUsersUseCase.execute()),null),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObjectDto> updatingUser(@RequestBody UserPerson user, @PathVariable("id") Long id){

        return new ResponseEntity<>(this.dataFactory.buildResponse("Usuario actualizado ", Arrays.asList(this.updateUserUseCase.execute(user,id)),null),HttpStatus.OK);
    }

    @GetMapping(value="/detalle/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectDto> listUserByName(@PathVariable(value="id") Long id){

        return new ResponseEntity<>( this.dataFactory
                .buildResponse("Consultar usuarios",Arrays.asList(this.findOneUser.execute(id)),null),HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteUser(@PathVariable(value="id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.deleteUserUseCase.execute(id));
    }
}
