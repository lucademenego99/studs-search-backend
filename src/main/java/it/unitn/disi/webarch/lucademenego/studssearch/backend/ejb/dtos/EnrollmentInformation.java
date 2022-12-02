package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrollmentInformation that = (EnrollmentInformation) o;
        if (!Objects.equals(matriculation, that.matriculation)) return false;
        if (!Objects.equals(courseId, that.courseId)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return 31 * matriculation.hashCode() + courseId.hashCode();
    }
}
