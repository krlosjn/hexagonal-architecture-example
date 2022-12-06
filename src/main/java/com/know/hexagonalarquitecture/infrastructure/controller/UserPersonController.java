package com.know.hexagonalarquitecture.infrastructure.controller;

import com.know.hexagonalarquitecture.application.usecase.ListUsersUseCase;
import com.know.hexagonalarquitecture.application.usecase.UserSaveUseCase;
import com.know.hexagonalarquitecture.domain.usuario.model.UserPerson;
import com.know.hexagonalarquitecture.infrastructure.helpers.dto.DataFactory;
import com.know.hexagonalarquitecture.infrastructure.helpers.dto.ObjectDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping(value="v1/solicitudes")
public class UserPersonController {


    private final UserSaveUseCase userSaveUseCase;

    private final DataFactory dataFactory;

    private final ListUsersUseCase listUsersUseCase;

    public UserPersonController(UserSaveUseCase userSaveUseCase, DataFactory dataFactory,ListUsersUseCase listUsersUseCase){
        this.userSaveUseCase=userSaveUseCase;
        this.dataFactory=dataFactory;
        this.listUsersUseCase=listUsersUseCase;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectDto> saveUser(@RequestBody UserPerson userPerson) throws Exception {
        return new ResponseEntity<>( this.dataFactory
                .buildResponse("Usuarios", Arrays.asList(this.userSaveUseCase.execute(userPerson)),null), HttpStatus.OK);
    }








}
