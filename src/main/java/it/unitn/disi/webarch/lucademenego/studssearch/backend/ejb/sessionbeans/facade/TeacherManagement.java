package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.TeacherInformation;

/**
 * Facade bean used to manage teachers
 */
public interface TeacherManagement {
    /**
     * Add a new teacher to the list of teachers
     * @param teacher Teacher to add
     * @return The newly created teacher, or null if there was an error
     */
    TeacherInformation addTeacher(TeacherInformation teacher);
}
