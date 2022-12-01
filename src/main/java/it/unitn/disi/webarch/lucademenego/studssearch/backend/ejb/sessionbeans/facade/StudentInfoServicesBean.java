package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.sessionbeans.facade;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAdvisory;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentComplete;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers.StudentAssembler;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers.CompleteStudentAssembler;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.StudentEntity;
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
            new StudentAssembler().assemble(s)
        ).collect(Collectors.toList());
    }

    @Override
    public StudentComplete getStudent(Integer matriculation) {
        return new CompleteStudentAssembler().assemble(studentBean.getStudent(matriculation));
    }

    @Override
    public StudentAdvisory getStudentAdvisoryChoices(Integer matriculation) {
        return null;
    }
}
