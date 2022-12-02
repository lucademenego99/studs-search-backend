package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;
import java.util.List;

public class StudentAndCourses implements Serializable {
    private Integer matriculation;
    private String name;
    private String surname;
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
