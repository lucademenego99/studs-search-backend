package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.CourseAndTeacher;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.CourseInformation;

/**
 * Facade bean used to manage courses
 */
public interface CourseManagement {

    /**
     * Add a new course to the list of available courses
     * @param course Course to add
     * @return added course, or null if there was an error
     */
    CourseInformation addNewCourse(CourseInformation course);

    /**
     * Assign a teacher to a certain course
     * @param id Course ID
     * @param teacherId Teacher ID
     * @return Updated course, or null if there was an error
     */
    CourseAndTeacher setTeacher(Integer id, Integer teacherId);
}
