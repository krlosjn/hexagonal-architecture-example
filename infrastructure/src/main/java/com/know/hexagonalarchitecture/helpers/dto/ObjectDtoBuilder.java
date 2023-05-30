package com.know.hexagonalarchitecture.helpers.dto;

import java.util.List;

public class ObjectDtoBuilder {

    private Object meta;
    private List<DetailDataDto> data;

    public ObjectDtoBuilder(){}

    protected ObjectDtoBuilder withMeta(Object meta){
        this.meta=meta;
        return this;
    }

    protected ObjectDtoBuilder withData(List<DetailDataDto> data){
        this.data=data;
        return this;
    }

    protected ObjectDto build(){
        return new ObjectDto(meta,data);
    }

}
