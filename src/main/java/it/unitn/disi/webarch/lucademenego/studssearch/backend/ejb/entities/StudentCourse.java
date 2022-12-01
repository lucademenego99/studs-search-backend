package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "STUDENT_COURSE")
public class StudentCourse implements Serializable {
    @EmbeddedId
    private StudentCourseId id = new StudentCourseId();

    @ManyToOne
    @MapsId("matriculation")
    private StudentEntity student;

    @ManyToOne
    @MapsId("id")
    private CourseEntity course;
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

    public StudentCourse(Integer matriculation, Integer courseId) {
        this.id = new StudentCourseId(matriculation, courseId);
    }

    public StudentCourse(Integer matriculation, Integer courseId, Integer vote) {
        this.id = new StudentCourseId(matriculation, courseId);
        this.vote = vote;
    }
}
