package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;
import java.util.Collection;

public class StudentAdvisory implements Serializable {
    private Integer matriculation;
    private String name;
    private String surname;
    private Collection<CourseComplete> courses;

    public Integer getMatriculation() {
        return matriculation;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Collection<CourseComplete> getCourses() {
        return courses;
    }
}
