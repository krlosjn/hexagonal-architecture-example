package com.know.hexagonalarquitecture.infrastructure.helpers.dto;


public class DetailObjectDto {

    private String type;
    private Object id;
    private Object attributes;

    public DetailObjectDto() {
    }

    public DetailObjectDto(String type, Object id, Object attributes) {
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
