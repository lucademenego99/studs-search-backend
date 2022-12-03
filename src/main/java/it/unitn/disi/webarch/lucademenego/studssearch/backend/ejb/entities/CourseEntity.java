package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/**
 * Database entity - `COURSE` table
 * The entity represents a course.
 * Each course has a 1:1 relationship with a teacher
 * Courses have an M:N relationship with students
 */
@Entity
@Table(name = "COURSE")
public class CourseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Course ID - primary key
     */
    private Integer id;

    /**
     * Course name
     */
    private String name;

    /**
     * Teacher assigned to the course
     */
    private TeacherEntity teacher;

    /**
     * List of students enrolled to the course
     */
    private Collection<StudentCourse> courseStudents;

    public CourseEntity() {}

    public CourseEntity(String name) {
        this.name = name;
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

    @Column(name = "NAME", nullable = false, length = 50)
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the assigned teacher.
     *
     * The course has a 1:1 relationship with the teacher.
     * On delete, we don't want the updates to cascade on the other entities.
     * The corresponding teacher is fetched lazily.
     * @return the assigned teacher, in form of a `TeacherEntity` entity
     */
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "TEACHER_ID")
    public TeacherEntity getTeacher() {
        return teacher;
    }
    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }

    /**
     * Get the students enrolled to the course
     *
     * The course has an M:N relationship with the students.
     * On delete, we don't want the updates to cascade on the other entities.
     * The students are fetched lazily.
     * @return list of students enrolled to the course, in form of a list of `StudentCourse` entities
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "course")
    public Collection<StudentCourse> getCourseStudents() {
        return this.courseStudents;
    }
    public void setCourseStudents(Collection<StudentCourse> courseStudents) {
        this.courseStudents = courseStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(name, that.name)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
