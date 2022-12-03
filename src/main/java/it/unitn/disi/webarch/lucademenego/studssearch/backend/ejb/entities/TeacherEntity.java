package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Database entity - `TEACHER` table
 * The entity represents the teachers
 *
 * Each teacher has a 1:1 relationship with a course, but since
 * it is unidirectional (course -> teacher), this class does not
 * expose the teacher's course
 */
@Entity
@Table(name = "TEACHER")
public class TeacherEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Teacher ID - primary key
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

    public TeacherEntity() {}

    public TeacherEntity(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "NAME", nullable = false, length = 30)
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "SURNAME", nullable = false, length = 30)
    public String getSurname() {
        return this.surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherEntity that = (TeacherEntity) o;
        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(surname, that.surname)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }
}
