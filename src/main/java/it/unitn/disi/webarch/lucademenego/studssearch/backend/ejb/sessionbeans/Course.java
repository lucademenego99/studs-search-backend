package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.CourseInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.CourseEntity;

/**
 * Interface for a Course bean, exposing useful functions to manage courses
 */
public interface Course {

    /**
     * Get a course given its ID
     * @param id ID of the course
     * @return corresponding CourseEntity, or null if not found
     */
    CourseEntity getCourse(Integer id);

    /**
     * Add a new course to the list of available courses
     * @param course Course to add
     * @return added course, or null if there was an error
     */
    CourseEntity addCourse(CourseInformation course);

    /**
     * Remove a course from the list of available courses
     * @param id Course ID
     * @return Deleted course, or null if there was an error
     */
    CourseEntity removeCourse(Integer id);

    /**
     * Assign a teacher to a certain course
     * @param id Course ID
     * @param teacherId Teacher ID
     * @return Updated course entity, or null if there was an error
     */
    CourseEntity setTeacher(Integer id, Integer teacherId);
}
