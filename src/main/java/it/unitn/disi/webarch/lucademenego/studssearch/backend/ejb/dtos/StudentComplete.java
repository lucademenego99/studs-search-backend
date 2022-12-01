package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;
import java.util.List;

public class StudentComplete implements Serializable {
    private Integer matriculation;
    private String name;
    private String surname;
    private List<CourseInformation> courses;

    public StudentComplete(Integer matriculation, String name, String surname, List<CourseInformation> courses) {
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
