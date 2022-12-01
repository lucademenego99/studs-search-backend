package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAdvisory;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentComplete;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentInformation;

import java.util.Collection;

public interface StudentInfoServices {
    Collection<StudentInformation> getStudents();

    StudentComplete getStudent(Integer matriculation);

    StudentAdvisory getStudentAdvisoryChoices(Integer matriculation);
}
