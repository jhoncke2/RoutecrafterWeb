package com.routecrafter.model;

public class Route {
    private int id;
    private String name;
    private String description;
    private int cityId;

    public Route() {
    }

    public Route(String name, String description, int cityId) {
        this.name = name;
        this.description = description;
        this.cityId = cityId;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}