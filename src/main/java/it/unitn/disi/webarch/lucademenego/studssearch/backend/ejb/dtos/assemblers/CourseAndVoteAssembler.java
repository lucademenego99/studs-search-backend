package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.CourseAndVote;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.StudentCourse;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.StudentEntity;

public class CourseAndVoteAssembler implements Assembler<StudentCourse, CourseAndVote>{
    @Override
    public CourseAndVote assemble(StudentCourse entity) {
        if (entity == null) {
            return null;
        }
        return new CourseAndVote(entity.getCourse().getName(), entity.getVote());
    }
}
