package com.know.hexagonalarchitecture.helpers.dto;

public class DetailDataDtoBuilder {

    private String type;
    private Object id;
    private Object attributes;


    public DetailDataDtoBuilder(){}


    protected DetailDataDtoBuilder withType(String type){
        this.type=type;
        return this;
    }


    protected DetailDataDtoBuilder withId(Object id){
        this.id=id;
        return this;
    }

    protected DetailDataDtoBuilder withAttributes(Object attributes){
        this.attributes=attributes;
        return  this;
    }

    protected DetailDataDto build(){
        return new DetailDataDto(type,id,attributes);
    }

}
