package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.EnrollmentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.StudentCourse;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.StudentEntity;

import java.util.Collection;

/**
 * Interface for a Student bean, exposing useful functions to manage students
 */
public interface Student {

    /**
     * Get all the students
     * @return list of all the students
     */
    Collection<StudentEntity> getAllStudents();

    /**
     * Get a certain student given its matriculation number
     * @param matriculation Student ID
     * @return the corresponding student entity, or null if not found
     */
    StudentEntity getStudent(Integer matriculation);

    /**
     * Add a new student to the list of students
     * @param student student to add
     * @return The newly added student, or null if there was an error
     */
    StudentEntity addStudent(StudentInformation student);

    /**
     * Enroll a student to a certain course
     * @param enrollment enrollment information
     * @return The newly created relationship between student and course, or null if there was an error
     */
    StudentCourse enrollToCourse(EnrollmentInformation enrollment);

    /**
     * Assign a vote to a certain student for a certain course
     * @param matriculation student ID
     * @param courseId course ID
     * @param vote assigned vote
     * @return The updated relationship between student and course, or null if there was an error
     */
    StudentCourse setVote(Integer matriculation, Integer courseId, Integer vote);
}
