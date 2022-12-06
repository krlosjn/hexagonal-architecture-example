package com.know.hexagonalarquitecture.infrastructure.helpers.buildersdto;

import com.know.hexagonalarquitecture.infrastructure.helpers.dto.DetailObjectDto;
import com.know.hexagonalarquitecture.infrastructure.helpers.dto.ObjectDto;

import java.util.List;

public class ObjectDtoBuilder {

    private Object meta;
    private List<DetailObjectDto> data;

    public ObjectDtoBuilder(){}

    public ObjectDtoBuilder withMeta(Object meta){
        this.meta=meta;
        return this;
    }

    public ObjectDtoBuilder withData(List<DetailObjectDto> data){
        this.data=data;
        return this;
    }

    public ObjectDto build(){
        return new ObjectDto(meta,data);
    }

}
