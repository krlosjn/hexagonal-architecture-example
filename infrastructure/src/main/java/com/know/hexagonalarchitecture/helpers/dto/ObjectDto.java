package com.know.hexagonalarchitecture.helpers.dto;

import java.util.List;

public class ObjectDto {
    private Object meta;
    private List<DetailDataDto> data;

    public ObjectDto(){}

    public ObjectDto(Object meta, List<DetailDataDto> data) {
        this.meta = meta;
        this.data = data;
    }

    public Object getMeta() {
        return meta;
    }

    public List<DetailDataDto> getData() {
        return data;
    }
}
