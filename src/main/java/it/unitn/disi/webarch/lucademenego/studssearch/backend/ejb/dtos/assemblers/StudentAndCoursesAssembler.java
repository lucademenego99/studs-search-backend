package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.CourseAndVote;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.CourseInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentAndCourses;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.StudentEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Assembler for the StudentAndCourses DTO
 */
public class StudentAndCoursesAssembler implements Assembler<StudentEntity, StudentAndCourses> {
    @Override
    public StudentAndCourses assemble(StudentEntity entity) {
        if (entity == null) {
            return null;
        }
        List<CourseAndVote> courseList = null;
        if (entity.getStudentCourses() != null)
            courseList = entity.getStudentCourses().stream().map(c -> new CourseAndVoteAssembler().assemble(c)).collect(Collectors.toList());
        return new StudentAndCourses(entity.getMatriculation(), entity.getName(), entity.getSurname(), courseList);
    }
}
