package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;
import java.util.Objects;

/**
 * TeacherInformation DTO. Exposed parameters:
 * - id: id of the teacher
 * - name: name of the teacher
 * - surname: surname of the teacher
 */
public class TeacherInformation implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Teacher ID
     */
    private Integer id;

    /**
     * Teacher name
     */
    private String name;

    /**
     * Teacher surname
     */
    private String surname;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public TeacherInformation() {}

    public TeacherInformation(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.id = -1;
    }

    public TeacherInformation(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherInformation that = (TeacherInformation) o;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(surname, that.surname)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + surname.hashCode();
    }
}
