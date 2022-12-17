package com.know.hexagonalarquitecture.domain.user.model;

public class UserPersonBuilder {

    private Long id;

    private String name;

    private String lastName;

    private String dniUser;

    public  UserPersonBuilder(){}

    public UserPersonBuilder withId(Long id){
        this.id=id;
        return this;
    }

    public UserPersonBuilder withName(String name){
        this.name=name;
        return this;
    }


    public UserPersonBuilder withLastName(String lastName){
        this.lastName=lastName;
        return this;
    }


    public UserPersonBuilder withDniUser(String dniUser){
        this.dniUser=dniUser;
        return this;
    }


    public UserPerson build(){
        return new UserPerson(id,name,lastName,dniUser);
    }

}
