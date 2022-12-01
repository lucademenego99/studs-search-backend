package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;

public class EnrollmentInformation implements Serializable {
    private Integer matriculation;
    private Integer courseId;

    public Integer getMatriculation() {
        return matriculation;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public EnrollmentInformation() {}

    public EnrollmentInformation(Integer matriculation, Integer courseId) {
        this.matriculation = matriculation;
        this.courseId = courseId;
    }
}
