package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.EnrollmentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentCourseInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentInformation;

/**
 * Facade bean used to manage students
 */
public interface StudentManagement {
    /**
     * Add a new student to the list of students
     * @param student student to add
     * @return Basic information about the newly added student, or null if there was an error
     */
    StudentInformation addNewStudent(StudentInformation student);

    /**
     * Enroll a student to a certain course
     * @param enrollment enrollment information
     * @return The added enrollment information, or null if there was an error
     */
    EnrollmentInformation enrollToCourse(EnrollmentInformation enrollment);

    /**
     * Assign a vote to a certain student for a certain course
     * @param matriculation student ID
     * @param courseId course ID
     * @param vote assigned vote
     * @return The updated relationship between student and course, or null if there was an error
     */
    StudentCourseInformation setVote(Integer matriculation, Integer courseId, Integer vote);
}
