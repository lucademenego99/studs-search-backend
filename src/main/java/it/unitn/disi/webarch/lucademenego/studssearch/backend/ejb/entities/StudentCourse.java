package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Database entity - `STUDENT_COURSE` join table
 * The entity represents the relationship between students and courses.
 *
 * Courses have an M:N relationship with students, and this table exposes it,
 * together with the corresponding vote the student got for each course.
 */
@Entity
@Table(name = "STUDENT_COURSE")
public class StudentCourse implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Table ID - a composite key composed by the matriculation and the course ID
     */
    @EmbeddedId
    private StudentCourseId id = new StudentCourseId();

    /**
     * This table may contain multiple records for each student: one for each course the student is enrolled in
     */
    @ManyToOne
    @MapsId("matriculation")
    private StudentEntity student;

    /**
     * This table may contain multiple records for each course: one for each time a student is enrolled to the given course
     */
    @ManyToOne
    @MapsId("id")
    private CourseEntity course;

    /**
     * Vote assigned to a given student for a given course
     */
    private Integer vote;

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    @Column(name = "VOTE")
    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

    public StudentCourse() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCourse that = (StudentCourse) o;
        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(student, that.student)) return false;
        if (!Objects.equals(course, that.course)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (student != null ? student.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        return result;
    }
}
