package com.example.techforum.dto;

public class CategoryDto {
    private  Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CategoryDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private String name;

    public CategoryDto() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
