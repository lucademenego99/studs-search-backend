package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.EnrollmentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentCourseInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers.EnrollmentAssembler;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers.StudentAssembler;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers.StudentCourseAssembler;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.Student;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
@Remote(StudentManagement.class)
public class StudentManagementBean implements StudentManagement {
    @Inject
    Student studentBean;

    @Override
    public StudentInformation addNewStudent(StudentInformation student) {
        return new StudentAssembler().assemble(studentBean.addStudent(student));
    }

    @Override
    public EnrollmentInformation enrollToCourse(EnrollmentInformation enrollment) {
        return new EnrollmentAssembler().assemble(studentBean.enrollToCourse(enrollment));
    }

    @Override
    public StudentCourseInformation setVote(Integer matriculation, Integer courseId, Integer vote) {
        return new StudentCourseAssembler().assemble(studentBean.setVote(matriculation, courseId, vote));
    }
}
