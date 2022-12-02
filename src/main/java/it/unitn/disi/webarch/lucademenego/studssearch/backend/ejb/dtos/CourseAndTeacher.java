package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;
import java.util.Objects;

public class CourseAndTeacher implements Serializable {
    private final String name;
    private final Integer teacherId;

    public String getName() {
        return name;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

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
