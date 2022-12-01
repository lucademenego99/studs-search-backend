package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;

public class CourseComplete implements Serializable {
    private String name;
    private TeacherInformation teacher;

    public String getName() {
        return name;
    }

    public TeacherInformation getTeacher() {
        return teacher;
    }
}
