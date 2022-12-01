package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.CourseInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.CourseEntity;

public class CourseInformationAssembler implements Assembler<CourseEntity, CourseInformation> {
    @Override
    public CourseInformation assemble(CourseEntity entity) {
        if (entity == null) {
            return null;
        }
        return new CourseInformation(entity.getName());
    }
}
