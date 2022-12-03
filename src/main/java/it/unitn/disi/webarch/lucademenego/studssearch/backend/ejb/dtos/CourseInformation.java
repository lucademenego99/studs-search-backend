package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;
import java.util.Objects;

/**
 * CourseInformation DTO. Exposed parameters:
 * - id: id of the course
 * - name: name of the course
 */
public class CourseInformation implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Course ID
     */
    private Integer id;

    /**
     * Course name
     */
    private String name;

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public CourseInformation() {}

    public CourseInformation(String name) {
        this.name = name;
        this.id = -1;
    }

    public CourseInformation(String name, Integer id) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseInformation that = (CourseInformation) o;
        return Objects.equals(name, that.name) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + id.hashCode();
    }
}
