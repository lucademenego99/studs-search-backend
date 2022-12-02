package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.CourseAndTeacher;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.CourseEntity;

public class CourseAndTeacherAssembler implements Assembler<CourseEntity, CourseAndTeacher> {
    @Override
    public CourseAndTeacher assemble(CourseEntity entity) {
        if (entity == null) {
            return null;
        }
        return new CourseAndTeacher(entity.getName(), entity.getTeacher().getId());
    }
}
