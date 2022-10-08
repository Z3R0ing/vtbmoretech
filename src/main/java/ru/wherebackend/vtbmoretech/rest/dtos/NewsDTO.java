package ru.wherebackend.vtbmoretech.rest.dtos;

import java.io.Serializable;

public class NewsDTO implements Serializable {
    private static final long serialVersionUID = 328134527718444748L;

    private String name;
    private String text;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
