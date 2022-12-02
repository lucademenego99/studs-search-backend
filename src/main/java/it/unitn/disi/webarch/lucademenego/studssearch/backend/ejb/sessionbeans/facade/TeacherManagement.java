package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.TeacherInformation;

public interface TeacherManagement {
    TeacherInformation addTeacher(TeacherInformation teacher);
}
