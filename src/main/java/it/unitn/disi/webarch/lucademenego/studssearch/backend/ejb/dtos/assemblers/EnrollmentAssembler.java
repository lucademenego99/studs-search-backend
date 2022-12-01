package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.EnrollmentInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.StudentCourse;

public class EnrollmentAssembler implements Assembler<StudentCourse, EnrollmentInformation>{
    @Override
    public EnrollmentInformation assemble(StudentCourse entity) {
        if (entity == null) {
            return null;
        }
        return new EnrollmentInformation(entity.getStudent().getMatriculation(), entity.getCourse().getId());
    }
}
