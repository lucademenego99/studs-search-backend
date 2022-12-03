package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.TeacherInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.TeacherEntity;

/**
 * Interface for a Teacher bean, exposing useful functions to manage teachers
 */
public interface Teacher {
    /**
     * Get a teacher given its ID
     * @param id Teacher ID
     * @return The corresponding teacher entity, or null if not found
     */
    TeacherEntity getTeacher(Integer id);

    /**
     * Add a new teacher to the list of teachers
     * @param teacher Teacher to add
     * @return The newly created teacher, or null if there was an error
     */
    TeacherEntity addTeacher(TeacherInformation teacher);
}
