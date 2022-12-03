package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.CourseInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentCourseInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.StudentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.StudentCourse;

/**
 * Assembler for the StudentCourseInformation DTO
 */
public class StudentCourseInformationAssembler implements Assembler<StudentCourse, StudentCourseInformation>{
    @Override
    public StudentCourseInformation assemble(StudentCourse entity) {
        if (entity == null) {
            return null;
        }
        StudentInformation student = new StudentInformationAssembler().assemble(entity.getStudent());
        CourseInformation course = new CourseInformationAssembler().assemble(entity.getCourse());
        if (student == null || course == null) {
            return null;
        }
        return new StudentCourseInformation(student, course, entity.getVote());
    }
}
