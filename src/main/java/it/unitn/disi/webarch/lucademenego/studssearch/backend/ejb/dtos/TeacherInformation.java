package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;

public class TeacherInformation implements Serializable {
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public TeacherInformation(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
