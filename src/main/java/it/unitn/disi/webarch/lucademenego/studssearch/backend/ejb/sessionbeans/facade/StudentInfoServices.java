package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAdvisorChoices;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAndCourses;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentInformation;

import java.util.Collection;

public interface StudentInfoServices {
    Collection<StudentInformation> getStudents();

    StudentAndCourses getStudent(Integer matriculation);

    StudentAdvisorChoices getStudentAdvisorChoices(Integer matriculation);
}
