package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class StudentAdvisorChoices implements Serializable {
    private final Integer matriculation;
    private final String name;
    private final String surname;
    private final List<TeacherInformation> teachers;

    public Integer getMatriculation() {
        return matriculation;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<TeacherInformation> getTeachers() {
        return teachers;
    }

    public StudentAdvisorChoices(Integer matriculation, String name, String surname, List<TeacherInformation> teachers) {
        this.matriculation = matriculation;
        this.name = name;
        this.surname = surname;
        this.teachers = teachers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentAdvisorChoices that = (StudentAdvisorChoices) o;
        if (!Objects.equals(matriculation, that.matriculation)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(surname, that.surname)) return false;
        if (!Objects.equals(teachers, that.teachers)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return 31 * matriculation.hashCode() + name.hashCode() + surname.hashCode() + teachers.hashCode();
    }
}
