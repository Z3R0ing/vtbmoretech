package ru.wherebackend.vtbmoretech.data;

import java.io.Serializable;
import java.util.UUID;

public class SaleNftDTO implements Serializable {

    private UUID id;
    private Double price;
    private String name;
    private String description;
    private String employeeName;
    private String uri;

    public SaleNftDTO(){};

    public SaleNftDTO(UUID id, Double price, String name, String description, String employeeName, String uri) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.description = description;
        this.employeeName = employeeName;
        this.uri = uri;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
