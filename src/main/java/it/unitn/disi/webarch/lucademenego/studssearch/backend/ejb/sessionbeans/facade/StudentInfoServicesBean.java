package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAdvisorChoices;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAndCourses;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers.StudentAdvisorChoicesAssembler;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers.StudentInformationAssembler;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers.StudentAndCoursesAssembler;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.Student;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Remote(StudentInfoServices.class)
public class StudentInfoServicesBean implements StudentInfoServices {
    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    @Inject
    Student studentBean;

    @Override
    public List<StudentInformation> getStudents() {
        return studentBean.getAllStudents().stream().map(s ->
            new StudentInformationAssembler().assemble(s)
        ).collect(Collectors.toList());
    }

    @Override
    public StudentAndCourses getStudent(Integer matriculation) {
        return new StudentAndCoursesAssembler().assemble(studentBean.getStudent(matriculation));
    }

    @Override
    public StudentAdvisorChoices getStudentAdvisorChoices(Integer matriculation) {
        return new StudentAdvisorChoicesAssembler().assemble(studentBean.getStudent(matriculation));
    }
}
