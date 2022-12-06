package com.know.hexagonalarquitecture.infrastructure.helpers.dto;

import java.util.List;

public class ObjectDto {
    private Object meta;
    private List<DetailObjectDto> data;

    public ObjectDto(){}

    public ObjectDto(Object meta, List<DetailObjectDto> data) {
        this.meta = meta;
        this.data = data;
    }

    public Object getMeta() {
        return meta;
    }

    public List<DetailObjectDto> getData() {
        return data;
    }
}
