package com.know.hexagonalarchitecture.infrastructure.helpers.dto;


public class DetailDataDto {

    private String type;
    private Object id;
    private Object attributes;

    public DetailDataDto() {
    }

    public DetailDataDto(String type, Object id, Object attributes) {
        this.type = type;
        this.id = id;
        this.attributes = attributes;
    }

    public String getType() {
        return type;
    }

    public Object getId() {
        return id;
    }

    public Object getAttributes() {
        return attributes;
    }
}
