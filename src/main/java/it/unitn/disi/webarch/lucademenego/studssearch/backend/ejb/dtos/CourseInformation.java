package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;
import java.util.Objects;

public class CourseInformation implements Serializable {
    private final Integer id;
    private final String name;

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

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
