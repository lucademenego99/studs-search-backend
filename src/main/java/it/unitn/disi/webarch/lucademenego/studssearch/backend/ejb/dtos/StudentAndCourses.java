package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;
import java.util.List;

/**
 * StudentAndCourses DTO. Exposed parameters:
 * - matriculation: id of the student
 * - name: name of the student
 * - surname: surname of the student
 * - courses: list of courses the student is enrolled in
 */
public class StudentAndCourses implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Student ID
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
    private List<CourseAndVote> courses;

    public StudentAndCourses() {}

    public StudentAndCourses(Integer matriculation, String name, String surname, List<CourseAndVote> courses) {
        this.matriculation = matriculation;
        this.name = name;
        this.surname = surname;
        this.courses = courses;
    }

    public Integer getMatriculation() {
        return matriculation;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<CourseAndVote> getCourses() {
        return courses;
    }

    public String mapCoursesToHTML() {
        StringBuilder html = new StringBuilder("<ul>");
        for (CourseAndVote course : courses) {
            html.append("<li>")
                    .append("<p>").append(course.getName()).append("</p>")
                    .append("<div class='vote'>").append(course.getVote() != null ? course.getVote() : "").append("</div>")
                    .append("</li>")
                    .append("<div class='neuro-divider'></div>");
        }
        html.append("</ul>");
        return html.toString();
    }
}
