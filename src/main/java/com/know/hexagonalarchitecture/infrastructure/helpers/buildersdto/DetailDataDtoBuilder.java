package com.know.hexagonalarchitecture.infrastructure.helpers.buildersdto;

import com.know.hexagonalarchitecture.infrastructure.helpers.dto.DetailDataDto;

public class DetailDataDtoBuilder {

    private String type;
    private Object id;
    private Object attributes;


    public DetailDataDtoBuilder(){}


    public DetailDataDtoBuilder withType(String type){
        this.type=type;
        return this;
    }


    public DetailDataDtoBuilder withId(Object id){
        this.id=id;
        return this;
    }

    public DetailDataDtoBuilder withAttributes(Object attributes){
        this.attributes=attributes;
        return  this;
    }

    public DetailDataDto build(){
        return new DetailDataDto(type,id,attributes);
    }

}
