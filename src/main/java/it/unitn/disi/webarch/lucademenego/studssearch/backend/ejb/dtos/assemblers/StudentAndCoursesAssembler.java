package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.CourseInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAndCourses;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.StudentEntity;

import java.util.List;
import java.util.stream.Collectors;

public class StudentAndCoursesAssembler implements Assembler<StudentEntity, StudentAndCourses> {
    @Override
    public StudentAndCourses assemble(StudentEntity entity) {
        if (entity == null) {
            return null;
        }
        List<CourseInformation> courseList = null;
        if (entity.getStudentCourses() != null)
            courseList = entity.getStudentCourses().stream().map(c -> new CourseInformationAssembler().assemble(c.getCourse())).collect(Collectors.toList());
        return new StudentAndCourses(entity.getMatriculation(), entity.getName(), entity.getSurname(), courseList);
    }
}
