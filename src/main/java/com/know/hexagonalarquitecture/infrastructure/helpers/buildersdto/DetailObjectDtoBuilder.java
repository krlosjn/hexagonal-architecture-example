package com.know.hexagonalarquitecture.infrastructure.helpers.buildersdto;

import com.know.hexagonalarquitecture.infrastructure.helpers.dto.DetailObjectDto;

public class DetailObjectDtoBuilder {

    private String type;
    private Object id;
    private Object attributes;


    public DetailObjectDtoBuilder(){}


    public DetailObjectDtoBuilder withType(String type){
        this.type=type;
        return this;
    }


    public DetailObjectDtoBuilder withId(Object id){
        this.id=id;
        return this;
    }

    public DetailObjectDtoBuilder withAttributes(Object attributes){
        this.attributes=attributes;
        return  this;
    }

    public DetailObjectDto build(){
        return new DetailObjectDto(type,id,attributes);
    }

}
