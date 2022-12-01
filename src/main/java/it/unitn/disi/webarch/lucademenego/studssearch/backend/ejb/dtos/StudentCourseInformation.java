package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

public class StudentCourseInformation {
    private StudentInformation student;
    private CourseInformation course;
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

    public StudentCourseInformation(StudentInformation student, CourseInformation course, Integer vote) {
        this.student = student;
        this.course = course;
        this.vote = vote;
    }
}
