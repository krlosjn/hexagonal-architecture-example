package com.know.hexagonalarchitecture.infrastructure.helpers.buildersdto;

import com.know.hexagonalarchitecture.infrastructure.helpers.dto.DetailDataDto;
import com.know.hexagonalarchitecture.infrastructure.helpers.dto.ObjectDto;

import java.util.List;

public class ObjectDtoBuilder {

    private Object meta;
    private List<DetailDataDto> data;

    public ObjectDtoBuilder(){}

    public ObjectDtoBuilder withMeta(Object meta){
        this.meta=meta;
        return this;
    }

    public ObjectDtoBuilder withData(List<DetailDataDto> data){
        this.data=data;
        return this;
    }

    public ObjectDto build(){
        return new ObjectDto(meta,data);
    }

}
