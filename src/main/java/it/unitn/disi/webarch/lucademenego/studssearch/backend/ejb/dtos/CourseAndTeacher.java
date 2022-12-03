package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;
import java.util.Objects;

/**
 * CourseAndTeacher DTO. Exposed parameters:
 * - name: name of the course
 * - teacherId: ID of the teacher assigned to the course
 */
public class CourseAndTeacher implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Course name
     */
    private String name;

    /**
     * Teacher ID
     */
    private Integer teacherId;

    public String getName() {
        return name;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public CourseAndTeacher() {}

    public CourseAndTeacher(String name, Integer teacherId) {
        this.name = name;
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseAndTeacher that = (CourseAndTeacher) o;
        return Objects.equals(name, that.name) && Objects.equals(teacherId, that.teacherId);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + teacherId.hashCode();
    }
}
