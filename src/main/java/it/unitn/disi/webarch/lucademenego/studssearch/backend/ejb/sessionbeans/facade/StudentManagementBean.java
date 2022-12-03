package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.EnrollmentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentCourseInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers.EnrollmentInformationAssembler;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers.StudentInformationAssembler;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers.StudentCourseInformationAssembler;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.Student;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

/**
 * Stateless remote bean exposing functions to manage students
 */
@Stateless
@Remote(StudentManagement.class)
public class StudentManagementBean implements StudentManagement {

    /**
     * Inject the student local bean for performing the operations
     */
    @Inject
    Student studentBean;

    @Override
    public StudentInformation addNewStudent(StudentInformation student) {
        return new StudentInformationAssembler().assemble(studentBean.addStudent(student));
    }

    @Override
    public EnrollmentInformation enrollToCourse(EnrollmentInformation enrollment) {
        return new EnrollmentInformationAssembler().assemble(studentBean.enrollToCourse(enrollment));
    }

    @Override
    public StudentCourseInformation setVote(Integer matriculation, Integer courseId, Integer vote) {
        return new StudentCourseInformationAssembler().assemble(studentBean.setVote(matriculation, courseId, vote));
    }
}
