package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

/**
 * Embeddable entity representing the Key of the STUDENT_COURSE table
 * The key is composed by the student matriculation number and the course ID
 */
@Embeddable
public class StudentCourseId implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Student ID
     */
    private Integer matriculation;

    /**
     * Course ID
     */
    private Integer id;

    public StudentCourseId() {}

    public StudentCourseId(Integer matriculation, Integer courseId) {
        this.matriculation = matriculation;
        this.id = courseId;
    }

    public Integer getMatriculation() {
        return matriculation;
    }
    public void setMatriculation(Integer matriculation) {
        this.matriculation = matriculation;
    }

    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCourseId that = (StudentCourseId) o;
        if (!Objects.equals(matriculation, that.matriculation)) return false;
        if (!Objects.equals(id, that.id)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = matriculation != null ? matriculation.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
