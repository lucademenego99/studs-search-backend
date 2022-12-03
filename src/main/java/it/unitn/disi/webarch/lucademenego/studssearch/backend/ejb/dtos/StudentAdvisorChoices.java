package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * StudentAdvisorChoices DTO. Exposed parameters:
 * - matriculation: id of the student
 * - name: name of the student
 * - surname: surname of the student
 * - teachers: list of possible advisors for the student
 */
public class StudentAdvisorChoices implements Serializable {
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
     * List of teachers that can become the student's advisors
     */
    private List<TeacherInformation> teachers;

    public Integer getMatriculation() {
        return matriculation;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<TeacherInformation> getTeachers() {
        return teachers;
    }

    public StudentAdvisorChoices() {}

    public StudentAdvisorChoices(Integer matriculation, String name, String surname, List<TeacherInformation> teachers) {
        this.matriculation = matriculation;
        this.name = name;
        this.surname = surname;
        this.teachers = teachers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentAdvisorChoices that = (StudentAdvisorChoices) o;
        if (!Objects.equals(matriculation, that.matriculation)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(surname, that.surname)) return false;
        if (!Objects.equals(teachers, that.teachers)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return 31 * matriculation.hashCode() + name.hashCode() + surname.hashCode() + teachers.hashCode();
    }

    public String mapTeachersToHTML() {
        StringBuilder html = new StringBuilder("<ul>");
        for (TeacherInformation teacher : teachers) {
            html.append("<li>")
                    .append("<p>").append(teacher.getName()).append(" ").append(teacher.getSurname()).append("</p>")
                    .append("<div class='outside-neuro check'></div>")
                    .append("</li>")
                    .append("<div class='neuro-divider'></div>");
        }
        html.append("</ul>");
        return html.toString();
    }
}
