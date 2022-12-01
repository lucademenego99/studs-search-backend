package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;
import java.util.List;

public class StudentAndCourses implements Serializable {
    private final Integer matriculation;
    private final String name;
    private final String surname;
    private final List<CourseInformation> courses;

    public StudentAndCourses(Integer matriculation, String name, String surname, List<CourseInformation> courses) {
        this.matriculation = matriculation;
        this.name = name;
        this.surname = surname;
        this.courses = courses;
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

    public List<CourseInformation> getCourses() {
        return courses;
    }
}
