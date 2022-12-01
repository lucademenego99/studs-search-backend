package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;
import java.util.Objects;

public class StudentInformation implements Serializable {
    private final Integer matriculation;
    private final String name;
    private final String surname;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentInformation that = (StudentInformation) o;
        if (!Objects.equals(matriculation, that.matriculation)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(surname, that.surname)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return 31 * matriculation.hashCode() + name.hashCode() + surname.hashCode();
    }
}
