package com.know.hexagonalarquitecture.infrastructure.controller;

import com.know.hexagonalarquitecture.application.usecase.ListUsersUseCase;
import com.know.hexagonalarquitecture.application.usecase.UserPersonNameFindUseCase;
import com.know.hexagonalarquitecture.application.usecase.UserSaveUseCase;
import com.know.hexagonalarquitecture.domain.usuario.model.UserPerson;
import com.know.hexagonalarquitecture.infrastructure.helpers.dto.DataFactory;
import com.know.hexagonalarquitecture.infrastructure.helpers.dto.ObjectDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping(value="v1/solicitudes")
public class UserPersonController {


    private final UserSaveUseCase userSaveUseCase;
    private final ListUsersUseCase listUsersUseCase;
    private final UserPersonNameFindUseCase userPersonNameFindUseCase;

    private final DataFactory dataFactory;



    public UserPersonController(UserSaveUseCase userSaveUseCase, DataFactory dataFactory, ListUsersUseCase listUsersUseCase, UserPersonNameFindUseCase userPersonNameFindUseCase){
        this.userSaveUseCase=userSaveUseCase;
        this.dataFactory=dataFactory;
        this.listUsersUseCase=listUsersUseCase;
        this.userPersonNameFindUseCase =userPersonNameFindUseCase;
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

    @GetMapping(value="/detail/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectDto> listUsersByName(@RequestParam(value="name") String name){

        return new ResponseEntity<>( this.dataFactory
                .buildResponse("Consultar usuarios",Arrays.asList(this.userPersonNameFindUseCase.execute(name)),null),HttpStatus.OK);
    }

}
