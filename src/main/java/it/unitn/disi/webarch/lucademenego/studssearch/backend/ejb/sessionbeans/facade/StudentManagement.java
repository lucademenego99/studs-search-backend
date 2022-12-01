package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.EnrollmentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentCourseInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentInformation;

public interface StudentManagement {
    StudentInformation addNewStudent(StudentInformation student);

    EnrollmentInformation enrollToCourse(EnrollmentInformation enrollment);

    StudentCourseInformation setVote(Integer matriculation, Integer courseId, Integer vote);
}
