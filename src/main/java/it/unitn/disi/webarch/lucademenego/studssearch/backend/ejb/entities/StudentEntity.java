package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Database entity - `STUDENT` table
 * The entity represents the students
 *
 * Students have an N:M relationship with courses
 */
@Entity
@Table(name = "STUDENT")
public class StudentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Student ID - primary key
     */
    private Integer matriculation;

    /**
     * Student name
     */
    private String name;

    /**
     * Student surname
     */
    private String surname;

    /**
     * List of courses the student is enrolled in
     */
    private Collection<StudentCourse> studentCourses = new ArrayList<StudentCourse>();

    public StudentEntity() {}

    public StudentEntity(Integer matriculation, String firstName, String lastName) {
        this.matriculation = matriculation;
        this.name = firstName;
        this.surname = lastName;
    }

    @Id
    @Column(name = "MATRICULATION", nullable = false)
    public Integer getMatriculation() {
        return matriculation;
    }
    public void setMatriculation(Integer matriculation) {
        this.matriculation = matriculation;
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

    /**
     * Get the list of courses the student is enrolled in
     *
     * On delete, we don't want the updates to cascade on the other entities.
     * The corresponding courses are fetched lazily.
     * @return a list of courses the student is enrolled in, in form of a list of `StudentCourse` entities
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "student")
    public Collection<StudentCourse> getStudentCourses() {
        return this.studentCourses;
    }
    public void setStudentCourses(Collection<StudentCourse> studentCourses) {
        this.studentCourses = studentCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        if (!Objects.equals(matriculation, that.matriculation)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(surname, that.surname)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = matriculation != null ? matriculation.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }
}
