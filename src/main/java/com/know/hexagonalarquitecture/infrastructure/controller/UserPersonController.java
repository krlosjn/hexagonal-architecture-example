package com.know.hexagonalarquitecture.infrastructure.controller;

import com.know.hexagonalarquitecture.application.user.usecase.ListUsersUseCase;
import com.know.hexagonalarquitecture.application.user.usecase.FindUserNameUseCase;
import com.know.hexagonalarquitecture.application.user.usecase.UpdateUserUseCase;
import com.know.hexagonalarquitecture.application.user.usecase.UserSaveUseCase;
import com.know.hexagonalarquitecture.domain.user.model.UserPerson;
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
    private final FindUserNameUseCase findUserNameUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DataFactory dataFactory;



    public UserPersonController(UserSaveUseCase userSaveUseCase, DataFactory dataFactory, ListUsersUseCase listUsersUseCase, FindUserNameUseCase userPersonNameFindUseCase,UpdateUserUseCase updateUserUseCase){
        this.userSaveUseCase=userSaveUseCase;
        this.dataFactory=dataFactory;
        this.listUsersUseCase=listUsersUseCase;
        this.findUserNameUseCase =userPersonNameFindUseCase;
        this.updateUserUseCase=updateUserUseCase;
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



    @PutMapping("/{dniUser}")
    public ResponseEntity<ObjectDto> updatingUser(@RequestBody UserPerson user, @RequestParam("dniUser") String dniUser){

        return new ResponseEntity<>(this.dataFactory.buildResponse("Usuario actualizado ", Arrays.asList(this.updateUserUseCase.execute(user,dniUser)),null),HttpStatus.OK);
    }



    /**
     * use case incomplete for now
     *
     * */
    @GetMapping(value="/detail/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectDto> listUserByName(@RequestParam(value="name") String name){

        return new ResponseEntity<>( this.dataFactory
                .buildResponse("Consultar usuarios",Arrays.asList(this.findUserNameUseCase.execute(name)),null),HttpStatus.OK);
    }

}
