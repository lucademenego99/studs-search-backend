package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAdvisorChoices;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAndCourses;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentInformation;

import java.util.List;

/**
 * Facade bean used to get information about students
 */
public interface StudentInfoServices {

    /**
     * Get all the students
     * @return list of all the students with basic information about them
     */
    List<StudentInformation> getStudents();

    /**
     * Get a certain student given its matriculation number
     * @param matriculation Student ID
     * @return the student with all the courses he is enrolled in, or null if not found
     */
    StudentAndCourses getStudent(Integer matriculation);

    /**
     * Get the possible advisor choices for a given student
     * @param matriculation Student ID
     * @return the student information and possible advisor choices, or null if not found
     */
    StudentAdvisorChoices getStudentAdvisorChoices(Integer matriculation);
}
