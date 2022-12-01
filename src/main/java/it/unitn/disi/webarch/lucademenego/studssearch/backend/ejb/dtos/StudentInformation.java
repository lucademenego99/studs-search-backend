package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;

public class StudentInformation implements Serializable {
    private Integer matriculation;
    private String name;
    private String surname;

    public StudentInformation(Integer matriculation, String name, String surname) {
        this.matriculation = matriculation;
        this.name = name;
        this.surname = surname;
    }

    public Integer getMatriculation() {
        return matriculation;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
