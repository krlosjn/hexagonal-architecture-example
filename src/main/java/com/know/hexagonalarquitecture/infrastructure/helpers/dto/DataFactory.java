package com.know.hexagonalarquitecture.infrastructure.helpers.dto;

import com.know.hexagonalarquitecture.infrastructure.helpers.buildersdto.DetailObjectDtoBuilder;
import com.know.hexagonalarquitecture.infrastructure.helpers.buildersdto.ObjectDtoBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class DataFactory {

    private final ObjectDtoBuilder objectDtoBuilder;

    private final DetailObjectDtoBuilder detailObjectDtoBuilder;

    public DataFactory(ObjectDtoBuilder objectDtoBuilder,DetailObjectDtoBuilder detailObjectDtoBuilder){
        this.objectDtoBuilder=objectDtoBuilder;
        this.detailObjectDtoBuilder=detailObjectDtoBuilder;
    }

    public  ObjectDto buildResponse(String type, List<Object> responses, Object metaData){
        return objectDtoBuilder
                .withData(responses.stream().map(resp->
                        detailObjectDtoBuilder.withType(type)
                                .withAttributes(resp)
                                .build()
                        ).collect(Collectors.toList()))
                .withMeta(metaData)
                .build();

    }

}
