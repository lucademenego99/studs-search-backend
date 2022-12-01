package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.CourseInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentComplete;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.CourseEntity;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.StudentEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CompleteStudentAssembler implements Assembler<StudentEntity, StudentComplete> {
    @Override
    public StudentComplete assemble(StudentEntity entity) {
        if (entity == null) {
            return null;
        }
        List<CourseInformation> courseList = null;
        if (entity.getStudentCourses() != null)
            courseList = entity.getStudentCourses().stream().map(c -> new CourseAssembler().assemble(c.getCourse())).collect(Collectors.toList());
        return new StudentComplete(entity.getMatriculation(), entity.getName(), entity.getSurname(), courseList);
    }

    private CourseInformation assemble(CourseEntity entity) {
        if (entity == null) {
            return null;
        }
        return new CourseInformation(entity.getName());
    }
}
