package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.TeacherInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.TeacherEntity;

public interface Teacher {
    TeacherEntity getTeacher(Integer id);
    TeacherEntity addTeacher(TeacherInformation teacher);
}
