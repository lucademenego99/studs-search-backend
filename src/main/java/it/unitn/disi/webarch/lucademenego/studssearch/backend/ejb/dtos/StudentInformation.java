package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;
import java.util.Objects;

/**
 * StudentInformation DTO. Exposed parameters:
 * - matriculation: id of the student
 * - name: name of the student
 * - surname: surname of the student
 */
public class StudentInformation implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Student ID
     */
    private Integer matriculation;

    /**
     * Student name
     */
    private String name;

    /**
     * Student surname
     */
    private String surname;

    public StudentInformation() {}

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
