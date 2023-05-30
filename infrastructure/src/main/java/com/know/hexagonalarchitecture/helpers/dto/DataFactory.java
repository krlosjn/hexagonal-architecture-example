 package com.know.hexagonalarchitecture.helpers.dto;

import java.util.List;
import java.util.stream.Collectors;

public class DataFactory {

    private final ObjectDtoBuilder objectDtoBuilder;

    private final DetailDataDtoBuilder detailObjectDtoBuilder;

    public DataFactory(ObjectDtoBuilder objectDtoBuilder, DetailDataDtoBuilder detailObjectDtoBuilder){
        this.objectDtoBuilder=objectDtoBuilder;
        this.detailObjectDtoBuilder=detailObjectDtoBuilder;
    }

    public   ObjectDto buildResponse(String type, List<Object> responses, Object metaData){
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
