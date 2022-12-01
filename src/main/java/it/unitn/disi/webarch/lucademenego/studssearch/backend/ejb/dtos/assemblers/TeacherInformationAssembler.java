package it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.assemblers;

import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.dtos.TeacherInformation;
import it.unitn.disi.webarch.lucademenego.studssearch.backend.ejb.entities.TeacherEntity;

public class TeacherInformationAssembler implements Assembler<TeacherEntity, TeacherInformation> {
    @Override
    public TeacherInformation assemble(TeacherEntity entity) {
        if (entity == null) {
            return null;
        }
        return new TeacherInformation(entity.getName(), entity.getSurname());
    }
}
