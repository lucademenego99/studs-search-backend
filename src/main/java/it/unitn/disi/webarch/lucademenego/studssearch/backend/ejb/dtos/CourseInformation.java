package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;

public class CourseInformation implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public CourseInformation(String name) {
        this.name = name;
    }
}
