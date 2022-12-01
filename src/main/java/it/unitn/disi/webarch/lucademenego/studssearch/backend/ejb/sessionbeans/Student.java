package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.EnrollmentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.StudentCourse;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.StudentEntity;

import java.util.Collection;

public interface Student {
    Collection<StudentEntity> getAllStudents();

    StudentEntity getStudent(Integer matriculation);

    StudentEntity addStudent(StudentInformation student);

    StudentCourse enrollToCourse(EnrollmentInformation enrollment);

    StudentCourse setVote(Integer matriculation, Integer courseId, Integer vote);
}
