package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAdvisorChoices;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.TeacherInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.StudentEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Assembler for the StudentAdvisorChoices DTO
 */
public class StudentAdvisorChoicesAssembler implements Assembler<StudentEntity, StudentAdvisorChoices> {
    @Override
    public StudentAdvisorChoices assemble(StudentEntity entity) {
        if (entity == null) {
            return null;
        }
        List<TeacherInformation> teachers = null;
        if (entity.getStudentCourses() != null)
            teachers = entity.getStudentCourses().stream().map(c -> new TeacherInformationAssembler().assemble(c.getCourse().getTeacher())).collect(Collectors.toList());
        return new StudentAdvisorChoices(entity.getMatriculation(), entity.getName(), entity.getSurname(), teachers);
    }
}
