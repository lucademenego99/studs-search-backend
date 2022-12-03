package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;
import java.util.Objects;

/**
 * StudentCourseInformation DTO. Exposed parameters:
 * - student: basic information about the student
 * - course: basic information about the course
 * - vote: vote assigned to the student
 */
public class StudentCourseInformation implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Student information
     */
    private StudentInformation student;

    /**
     * Course information
     */
    private CourseInformation course;

    /**
     * Assigned vote for the given course to the student
     */
    private Integer vote;

    public StudentInformation getStudent() {
        return student;
    }

    public CourseInformation getCourse() {
        return course;
    }

    public Integer getVote() {
        return vote;
    }

    public StudentCourseInformation() {}

    public StudentCourseInformation(StudentInformation student, CourseInformation course, Integer vote) {
        this.student = student;
        this.course = course;
        this.vote = vote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCourseInformation that = (StudentCourseInformation) o;
        if (!Objects.equals(student, that.student)) return false;
        if (!Objects.equals(course, that.course)) return false;
        if (!Objects.equals(vote, that.vote)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return 31 * student.hashCode() + course.hashCode() + vote.hashCode();
    }
}
